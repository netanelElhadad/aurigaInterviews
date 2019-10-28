package com.nati.aurigainterviewsbackend.logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nati.aurigainterviewsbackend.beans.Device;
import com.nati.aurigainterviewsbackend.beans.DeviceDetails;
import com.nati.aurigainterviewsbackend.dao.DeviceDbDao;
import com.nati.aurigainterviewsbackend.enums.ErrorType;
import com.nati.aurigainterviewsbackend.exceptions.ApplicationException;
import com.nati.aurigainterviewsbackend.utils.RequestUtils;


//'@Service\@Controller' make that object to 'managed object', specific for the
// Logic and giving you the 'Controller Bean Service'
@Service
public class DeviceLogic {
	
	@Autowired
	private DeviceDbDao deviceDao;
	

		// i return String on purpose, not object, because you expect the answer start with “name” and simple object will return "name".
		public String getDeviceInterviewRequirementsDetailsById(String deviceId) throws ApplicationException, FileNotFoundException, IOException {
			// i put this function separate to be generic, in case we'll want change the 'Requirements' so we still can use this function.
			DeviceDetails device = getDeviceDetailsById(deviceId);
			String deviceName = "“name”: \"" + device.getName() + "\", ";
			String deviceAgentVersion = "\"agentVersion\": \"" + device.getAgentVersion() + "\", ";
			String deviceAmountOfAlerts = "\"howManyAlerts\": " + device.getAlertIds().length + ", ";
			String deviceArchitecture = "\"architecture\": \"" + device.getArchitecture() + "\", ";
			String deviceCollector = "\"collector\": \"" + device.getCollector().getCollectorName() + "\", ";
			String deviceCpuModel = "\"cpuModel\": \"" + device.getCpuModel() + "\", ";
			String deviceDescription = "\"description\": \"" + device.getDescription() + "\", ";
			// we creating Date format by 'device.getDiscoveryDate' format, to be able to receive 'device.getDiscoveryDate' to it.
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
			// we creating Date format that we like to convert 'device.getDiscoveryDate' to it.
			SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null; 
			try {
				// we insert into 'format1' the 'device.getDiscoveryDate' and point to Date object to be able insert it to the format
				// we like by 'format' fun 
				date = format1.parse(device.getDiscoveryDate());
			} catch (ParseException e) {
				// we throw 'ApplicationException' just to be essay understanding the problem from the log, so we writing all the problem details into the log.
				throw new ApplicationException("Failed to parse `device Discovery Date` into 'SimpleDateFormat', device id = " + deviceId + ", device Discovery Date = " + device.getDiscoveryDate() + ", SimpleDateFormat = " + format1.toPattern()  , e);
			}
			String deviceDiscoveryDate = "\"discoveryDate\": \"" + format2.format(date) + "\", ";
			String deviceFirstIpAddres = device.getIpAddresses()[0].getIpAddress();
			String deviceSecondIpAddres = device.getIpAddresses()[1].getIpAddress();
			String deviceIpAddresses = "\"ipAddresses\": [\"" + deviceFirstIpAddres + "\",”" + deviceSecondIpAddres + "”]";
			String deviceDetailsByInterviewRequirements = "{ " + deviceName+deviceAgentVersion+deviceAmountOfAlerts+deviceArchitecture+deviceCollector+deviceCpuModel+deviceDescription+deviceDiscoveryDate+deviceIpAddresses + " }";
			return deviceDetailsByInterviewRequirements;
		}
	
	// those exceptions given me all the details i need so i don't wrap them with 'ApplicationException'
	private DeviceDetails getDeviceDetailsById (String deviceId) throws FileNotFoundException, IOException, ApplicationException {
		ObjectMapper mapper = new ObjectMapper();
		// If the URL was real i was activate 1 of the 2 options ahead and canceling the next String.
		// also I would do in both of the options as follows: if(we got wrong answer from the URL -maybe them server full down- (!HttpURLConnection.HTTP_OK)) {
		// we bring to here 'Device' object from our DB with 'getDeviceById' Function(if we don't have the object in our DB we send error massage to the client),
		// and extract from that object, the right String, and maybe send to client massage "the details right to X date.."
		// }else(HttpURLConnection.HTTP_OK){ we save the Data in the list\string, then extract from it the right String, 
		// also check if(the data NOT equals to our data in DB | we don't have that data){update\insert to our DB, maybe add column 'updateDate' }.
		// I send request every time and not go to our DB because maybe the data get an update. 
		// 1 option - BEST
		// Convert the Json we get from the URL to list of object 'Device'.
		// List<Device> deviceList  = Arrays.asList(mapper.readValue(new URL("https://api.cybergator.co.uk/testing/devices"), Device[].class));
		// 2 option
		// Get Json in string from URL by 'GetGETRequestResult' fun.
		// Then continue to the line that convert the 'DeviceListInString' Json string into list of Device object.
		// String deviceListInString = RequestUtils.GetGETRequestResult("https://api.cybergator.co.uk/testing/devices=1"); ;
		
		Properties applicationProperties = new Properties();
		// we loud the 'application.properties', now we have access to the properties there
		applicationProperties.load(new FileInputStream("./src/main/resources/application.properties"));
		// this is the long DATA i supposed to get from "https://api.cybergator.co.uk/testing/devices"
		String deviceListInString = applicationProperties.getProperty("aurigaTestDeviceListInString");;
		
		// we convert the 'deviceListInString' Json string into list of 'Device'
		List<Device> deviceList = Arrays.asList(mapper.readValue(deviceListInString, Device[].class));
		
		// the string we going to return in the end of the Function
		DeviceDetails deviceDetails = null;
		// we go over all the 'deviceList' to find the specific 'device' we look for.
		// that 'for loop' is for generic, in case we'll add to the 'deviceList' another 'device' in the future.
		for(Device device: deviceList) {
			if (device.getDeviceDetails().getDeviceId().equals(deviceId)) {
				deviceDetails = device.getDeviceDetails();
				return deviceDetails;
			}
		}
		
		// in case we got here it's mean we didn't find the device we look for so 'deviceDetails' still null, so now 
		// we can check if we have that device by ID in our DB and initializing 'deviceDetails' to it.
		// if we don't have in DB, we throw us own 'AplicationException' with error to the client and to the log.
		// the 'ErrorType' just example if we want to send specific 'error massage' to the client.
		throw new ApplicationException("Failed to get device details by id, device id = " + deviceId , ErrorType.WE_ARE_SORY_THERE_IS_A_GENERAL_ERROR);
	}
	
	
	public void createDevice(Device dvice) throws ApplicationException {
		// just example of logic validation 
		validateLengthDeviceDescription(dvice.getDeviceDetails().getDescription());
		deviceDao.createDevice(dvice);
	}
	
	private void validateLengthDeviceDescription(String dviceDescription) throws ApplicationException {
		if (!(dviceDescription.length() >= 5 && dviceDescription.length() <= 80)) {
			throw new ApplicationException("Dvice description is not valid (should be between 5-80 characters), dvice description = " + dviceDescription);
		}
	}

	public Optional<Device> getDeviceById(String deviceId) {
		return deviceDao.getDeviceById(deviceId);
	}

} 


