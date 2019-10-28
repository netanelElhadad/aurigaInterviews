package com.nati.aurigainterviewsbackend.beans;

import java.util.Arrays;

import org.springframework.stereotype.Component;

public class DeviceDetails {
	
	private String agentVersion, architecture, cpuModel, description, deviceId,discoveryDate, externalIp, externalIpCordLat, externalIpCordLong, 
				   externalIpDateUpdated, lastSeenDate, name, osCode, platform, registeredDate, release, updatesScriptLastRun;
	private String[] alertIds;
	private Tenant collector;
	private long cpuNumber;
	private IpAddress[] ipAddresses;
	private boolean isAgentConnected;
	
	
	public DeviceDetails() {
	}
	
	public DeviceDetails(String agentVersion, String[] alertIds, String architecture, Tenant collector,
			String cpuModel, long cpuNumber, String description, String deviceId, String discoveryDate,
			String externalIp, String externalIpCordLat, String externalIpCordLong, String externalIpDateUpdated,
			IpAddress[] ipAddresses, boolean isAgentConnected, String lastSeenDate, String name, String osCode,
			String platform, String registeredDate, String release, String updatesScriptLastRun) {
		super();
		this.agentVersion = agentVersion;
		this.alertIds = alertIds;
		this.architecture = architecture;
		this.collector = collector;
		this.cpuModel = cpuModel;
		this.cpuNumber = cpuNumber;
		this.description = description;
		this.deviceId = deviceId;
		this.discoveryDate = discoveryDate;
		this.externalIp = externalIp;
		this.externalIpCordLat = externalIpCordLat;
		this.externalIpCordLong = externalIpCordLong;
		this.externalIpDateUpdated = externalIpDateUpdated;
		this.ipAddresses = ipAddresses;
		this.isAgentConnected = isAgentConnected;
		this.lastSeenDate = lastSeenDate;
		this.name = name;
		this.osCode = osCode;
		this.platform = platform;
		this.registeredDate = registeredDate;
		this.release = release;
		this.updatesScriptLastRun = updatesScriptLastRun;
	}


	public String getAgentVersion() {
		return agentVersion;
	}

	public void setAgentVersion(String agentVersion) {
		this.agentVersion = agentVersion;
	}

	public String[] getAlertIds() {
		return alertIds;
	}

	public void setAlertIds(String[] alertIds) {
		this.alertIds = alertIds;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public Tenant getCollector() {
		return collector;
	}

	public void setCollector(Tenant collector) {
		this.collector = collector;
	}

	public String getCpuModel() {
		return cpuModel;
	}

	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}

	public long getCpuNumber() {
		return cpuNumber;
	}

	public void setCpuNumber(long cpuNumber) {
		this.cpuNumber = cpuNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDiscoveryDate() {
		return discoveryDate;
	}

	public void setDiscoveryDate(String discoveryDate) {
		this.discoveryDate = discoveryDate;
	}

	public String getExternalIp() {
		return externalIp;
	}

	public void setExternalIp(String externalIp) {
		this.externalIp = externalIp;
	}

	public String getExternalIpCordLat() {
		return externalIpCordLat;
	}

	public void setExternalIpCordLat(String externalIpCordLat) {
		this.externalIpCordLat = externalIpCordLat;
	}

	public String getExternalIpCordLong() {
		return externalIpCordLong;
	}

	public void setExternalIpCordLong(String externalIpCordLong) {
		this.externalIpCordLong = externalIpCordLong;
	}

	public String getExternalIpDateUpdated() {
		return externalIpDateUpdated;
	}

	public void setExternalIpDateUpdated(String externalIpDateUpdated) {
		this.externalIpDateUpdated = externalIpDateUpdated;
	}

	public IpAddress[] getIpAddresses() {
		return ipAddresses;
	}

	public void setIpAddresses(IpAddress[] ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

	public boolean getIsAgentConnected() {
		return isAgentConnected;
	}

	public void setAgentConnected(boolean isAgentConnected) {
		this.isAgentConnected = isAgentConnected;
	}

	public String getLastSeenDate() {
		return lastSeenDate;
	}

	public void setLastSeenDate(String lastSeenDate) {
		this.lastSeenDate = lastSeenDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOsCode() {
		return osCode;
	}

	public void setOsCode(String osCode) {
		this.osCode = osCode;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getUpdatesScriptLastRun() {
		return updatesScriptLastRun;
	}

	public void setUpdatesScriptLastRun(String updatesScriptLastRun) {
		this.updatesScriptLastRun = updatesScriptLastRun;
	}


	@Override
	public String toString() {
		return "DeviceDetails [agentVersion=" + agentVersion + ", alertIds=" + Arrays.toString(alertIds) + ", architecture="
				+ architecture + ", collector=" + collector + ", cpuModel=" + cpuModel + ", cpuNumber=" + cpuNumber
				+ ", description=" + description + ", deviceId=" + deviceId + ", discoveryDate=" + discoveryDate
				+ ", externalIp=" + externalIp + ", externalIpCordLat=" + externalIpCordLat + ", externalIpCordLong="
				+ externalIpCordLong + ", externalIpDateUpdated=" + externalIpDateUpdated + ", ipAddresses="
				+ Arrays.toString(ipAddresses) + ", isAgentConnected=" + isAgentConnected + ", lastSeenDate="
				+ lastSeenDate + ", name=" + name + ", osCode=" + osCode + ", platform=" + platform
				+ ", registeredDate=" + registeredDate + ", release=" + release + ", updatesScriptLastRun="
				+ updatesScriptLastRun + "]";
	}

}
