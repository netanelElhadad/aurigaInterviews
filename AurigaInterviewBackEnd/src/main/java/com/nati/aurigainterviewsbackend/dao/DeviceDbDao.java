package com.nati.aurigainterviewsbackend.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nati.aurigainterviewsbackend.beans.Device;
import com.nati.aurigainterviewsbackend.beans.DeviceDetails;
import com.nati.aurigainterviewsbackend.beans.IpAddress;
import com.nati.aurigainterviewsbackend.beans.Tenant;


// @Repository make that object to 'managed object', specific for the
// DAO that connect to the DB, and giving you the 'Dao Bean Service'.
// every Bean is singleton by default
@Repository
public class DeviceDbDao implements DeviceDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public DeviceDbDao() {
	}

	@Override
	public void createDevice(Device device) {
		System.out.println("DeviceDBDao-createDevice");
		String sqlQuery = "insert into Devices(DEVICE_ID, AGENT_VERSION, ALERT_ID_1, ALERT_ID_2, ARCHITECTURE, TENANT_ID, COLLECTOR_ID, COLLECTOR_NAME, CPU_MODEL, CPU_NUMBER, DESCRIPTION, DISCOVERY_DATE, EXTERNAL_IP, EXTERNAL_IP_CORD_LAT, EXTERNAL_IP_CORD_LONG, EXTERNAL_IP_DATE_UPDATED, IP_ADDRESS_1, IP_FAMILY_1, MAC_ADDRESS_1, IP_ADDRESS_2, IP_FAMILY_2, MAC_ADDRESS_2, IS_AGENT_CONNECTED, LAST_SEEN_DATE, DEVICE_NAME, OS_CODE, PLATFORM, REGISTERED_DATE, RELEASE, UPDATES_SCRIPT_LAST_RUN) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// just to be easy to call it a lot in next line
		DeviceDetails dev = device.getDeviceDetails();
		// we get all the parameters value from 'Device' to insert them into the Question Marks
		Object[] arguments = {dev.getDeviceId(), dev.getAgentVersion(), dev.getAlertIds()[0], dev.getAlertIds()[1], dev.getArchitecture(), dev.getCollector().getTenantId(), dev.getCollector().getCollectorId(), dev.getCollector().getCollectorName(), dev.getCpuModel(), dev.getCpuNumber(), dev.getDescription(), dev.getDiscoveryDate(), dev.getExternalIp(), dev.getExternalIpCordLat(), dev.getExternalIpCordLong(), dev.getExternalIpDateUpdated(), dev.getIpAddresses()[0].getIpAddress(), dev.getIpAddresses()[0].getIpFamily(), dev.getIpAddresses()[0].getMacAddress(), dev.getIpAddresses()[1].getIpAddress(), dev.getIpAddresses()[1].getIpFamily(), dev.getIpAddresses()[1].getMacAddress(), dev.getIsAgentConnected(), dev.getLastSeenDate(), dev.getName(), dev.getOsCode(), dev.getPlatform(), dev.getRegisteredDate(), dev.getRelease(), dev.getUpdatesScriptLastRun()};		
		// we tell 'jdbcTemplate' to do the 'sqlQuery' with the 'arguments' above
		jdbcTemplate.update(sqlQuery,arguments);
	}

	@Override
	// some code, if important to you, give me another day' i'll do it.
	public Optional<Device> getDeviceById(String deviceId) {
		return jdbcTemplate.queryForObject(
                "SELECT * FROM Devices where DEVICE_ID = ?",
                new Object[]{deviceId},
                (rs, rowNum) ->
                        Optional.of(new Device(
                                		new DeviceDetails(
                                				rs.getString("AGENT_VERSION"),
                                				new String[] {
                                						rs.getString("ALERT_ID_1"),
                                        				rs.getString("ALERT_ID_2")
                                				},
                                				rs.getString("ARCHITECTURE"),
                                				new Tenant(
                                						rs.getString("TENANT_ID"),
                                        				rs.getString("COLLECTOR_ID"),
                                        				rs.getString("COLLECTOR_NAME")
                                				),
                                				rs.getString("CPU_MODEL"),
                                				rs.getLong("CPU_NUMBER"),
                                				rs.getString("DESCRIPTION"),
                                				rs.getString("DEVICE_ID"),
                                				rs.getString("DISCOVERY_DATE"),
                                				rs.getString("EXTERNAL_IP"),
                                				rs.getString("EXTERNAL_IP_CORD_LAT"),
                                				rs.getString("EXTERNAL_IP_CORD_LONG"),
                                				rs.getString("EXTERNAL_IP_DATE_UPDATED"),
                                				new IpAddress[]{
                                						new IpAddress(
	                                						rs.getString("IP_ADDRESS_1"),
	                                        				rs.getString("IP_FAMILY_1"),
	                                        				rs.getString("MAC_ADDRESS_1")
	                                        				), 
		                                				 new IpAddress(
		                                						rs.getString("IP_ADDRESS_2"),
		                                        				rs.getString("IP_FAMILY_2"),
		                                        				rs.getString("MAC_ADDRESS_2")
	                            						 )
                                				},
                                				rs.getBoolean("IS_AGENT_CONNECTED"),
                                				rs.getString("LAST_SEEN_DATE"),
                                				rs.getString("DEVICE_NAME"),
                                				rs.getString("OS_CODE"),
                                				rs.getString("PLATFORM"),
                                				rs.getString("REGISTERED_DATE"),
                                				rs.getString("RELEASE"),
                                				rs.getString("UPDATES_SCRIPT_LAST_RUN")
                                                 
                                		)
                        ))
        );
	}


}
