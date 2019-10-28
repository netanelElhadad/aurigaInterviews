package com.nati.aurigainterviewsbackend.beans;


public class IpAddress {
	
	private String ipAddress, ipFamily, macAddress;
	
	
	public IpAddress() {
	}
	
	
	public IpAddress(String ipAddress, String ipFamily, String macAddress) {
		super();
		this.ipAddress = ipAddress;
		this.ipFamily = ipFamily;
		this.macAddress = macAddress;
	}


	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIpFamily() {
		return ipFamily;
	}

	public void setIpFamily(String ipFamily) {
		this.ipFamily = ipFamily;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	
	@Override
	public String toString() {
		return "IpAddress [ipAddress=" + ipAddress + ", ipFamily=" + ipFamily + ", macAddress=" + macAddress + "]";
	}

}
