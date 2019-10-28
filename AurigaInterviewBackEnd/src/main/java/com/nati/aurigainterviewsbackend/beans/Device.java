package com.nati.aurigainterviewsbackend.beans;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {

	
	// @JsonAlias mapping the key in Json to that variable, i did it because variable name can't Start with number or contain '-'.
	@JsonAlias({"2b727991-5ddb-4a42-82eb-13bbb2876a28", "if we added to the long data another device we need to add it's ID to here" })
	private DeviceDetails deviceDetails;

	
	public Device() {
	}

	
	public Device(DeviceDetails deviceDetails) {
		this.deviceDetails = deviceDetails;
	}


	public DeviceDetails getDeviceDetails() {
		return deviceDetails;
	}

	public void setDeviceDetails(DeviceDetails deviceDetails) {
		this.deviceDetails = deviceDetails;
	}


	@Override
	public String toString() {
		return "Device [deviceDetails=" + deviceDetails + "]";
	}

	
}
