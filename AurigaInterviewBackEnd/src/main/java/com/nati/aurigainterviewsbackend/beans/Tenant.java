package com.nati.aurigainterviewsbackend.beans;

public class Tenant {

	private String tenantId, collectorId, collectorName;
	
	
	public Tenant() {
	}

	
	public Tenant(String tenantId, String collectorId, String collectorName) {
		super();
		this.tenantId = tenantId;
		this.collectorId = collectorId;
		this.collectorName = collectorName;
	}


	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getCollectorId() {
		return collectorId;
	}

	public void setCollectorId(String collectorId) {
		this.collectorId = collectorId;
	}

	public String getCollectorName() {
		return collectorName;
	}

	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}

	
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", collectorId=" + collectorId + ", collectorName=" + collectorName
				+ "]";
	}
	
}
