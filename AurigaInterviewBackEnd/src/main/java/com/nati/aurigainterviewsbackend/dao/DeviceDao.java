package com.nati.aurigainterviewsbackend.dao;

import java.util.Optional;

import com.nati.aurigainterviewsbackend.beans.Device;


public interface DeviceDao {
	
	public void createDevice(Device device);
	public Optional<Device> getDeviceById (String id);

}
