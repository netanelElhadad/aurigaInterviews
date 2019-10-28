package com.nati.aurigainterviewsbackend;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nati.aurigainterviewsbackend.api.DeviceApi;
import com.nati.aurigainterviewsbackend.applicationconfiguration.ApplicationConfiguration;
import com.nati.aurigainterviewsbackend.beans.Device;
import com.nati.aurigainterviewsbackend.beans.DeviceDetails;
import com.nati.aurigainterviewsbackend.beans.IpAddress;
import com.nati.aurigainterviewsbackend.beans.Tenant;
import com.nati.aurigainterviewsbackend.dao.DeviceDao;
import com.nati.aurigainterviewsbackend.dao.DeviceDbDao;
import com.nati.aurigainterviewsbackend.exceptions.ApplicationException;
import com.nati.aurigainterviewsbackend.logic.DeviceLogic;



// Among other things we tell spring to read that class first
@SpringBootApplication
public class Main {
	 
	public static void main(String[] args) throws IOException, ParseException, ApplicationException {
		 SpringApplication.run(Main.class, args);
		 System.out.println();
		 ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		 System.out.println();
		 
		 DeviceApi api = (DeviceApi)context.getBean("deviceApi");
		 System.out.println("Device Details By Interview Requirements "+api.getDeviceDetailsByInterviewRequirements("2b727991-5ddb-4a42-82eb-13bbb2876a28"));
		 System.out.println();
		 
		 IpAddress[] s = new IpAddress[]{new IpAddress("","",""), new IpAddress("","","")};
		 String[] d = new String[] {"",""};
		 
		 int[] myIntArray = {1, 2, 3};
		 int[] myIntArray2 = new int[]{1, 2, 3};
		 
		
		 //System.out.println("Bean names: " + Arrays.toString(context.getBeanNamesForType(AurigaTestDeviceDbDao.class)));
		
		 //DeviceDao dao = (DeviceDao)context.getBean("deviceDbDao");
		 //DeviceLogic logic = (DeviceLogic)context.getBean("deviceLogic");
		 //DeviceLogic logic = new DeviceLogic();
		
		 Tenant tenant = new Tenant("asds", "asds", "asd");
		 IpAddress ipAddress1 = new IpAddress("sad1", "sad", "sccs");
		 IpAddress ipAddress2 = new IpAddress("sad2", "sad", "sccs");
		 IpAddress[] ipAddress = new IpAddress[2];
		 ipAddress[0] = ipAddress1;
		 ipAddress[1] = ipAddress2;
		 String s1 = "asd";
		 String s2 = "asd";
		 String[] ss = new String[2];
		 ss[0] = s1;
		 ss[1] = s2;
		
		 DeviceDetails deviceDetails = new DeviceDetails("asd", ss, "asdsad", tenant, "Dsda", 123, "desasdasd", "dfasds", "asda", "dadsa", "sfsdcz", "sdsaASC", "CASDC", ipAddress, true, "asdasc", "asdas", "asd", "asd", "sda", "caasc", "acsasdx");
		 Device device = new Device(deviceDetails);

 api.createDevice(device);
 System.out.println("create device work");
		
 System.out.println("into getttt");
System.out.println(api.getDeviceById("2b727991-5ddb-4a42-82eb-13bbb2876a28"));
System.out.println("getttt workkk");
		
		 
	}

}
