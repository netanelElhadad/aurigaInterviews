package com.nati.aurigainterviewsbackend.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nati.aurigainterviewsbackend.beans.Device;
import com.nati.aurigainterviewsbackend.exceptions.ApplicationException;
import com.nati.aurigainterviewsbackend.logic.DeviceLogic;

// enable CORS (Cross-origin resource sharing)
@CrossOrigin
//'@RestController' make that object to 'managed object', specific for the
// API and giving you the 'Api Bean Service' 
@RestController
//'@RequestMapping - path' say what 'URL HTTP request' we will mapping to here.
// consumes and produces convert to Json
@RequestMapping(path = "/device", consumes = "application/json", produces = "application/json")
public class DeviceApi {
	
	// '@Autowired' injects the 'managed object' to here (we have to make shore that object is really 'managed')
	@Autowired 
	private DeviceLogic deviceLogic;
	
	
	@GetMapping("/detailsByInterviewRequirements")
	// now we get to the URL like that 'aurigaDC01DeviceByInterviewRequirements?divuceID=some value..'.
	// we could delete the Parenthesis after '@RequestParam', then we got to here by the same URL just 'deviceId' instead 'deviceID'
	public String getDeviceDetailsByInterviewRequirements(@RequestParam("deviceID") String deviceId) throws  ApplicationException, FileNotFoundException, IOException {
		return deviceLogic.getDeviceInterviewRequirementsDetailsById(deviceId);
	}
	
	@GetMapping("/deviceById")
	public Optional<Device> getDeviceById(@RequestParam("deviceID")String deviceId) {
		return deviceLogic.getDeviceById(deviceId);
	}
	
	// we convert the response to 'json'
	@PostMapping("/createDevice")
	public void createDevice(@RequestBody Device device) throws ApplicationException {
		deviceLogic.createDevice(device);
	}

}
