package com.app.Model;

import java.util.Objects;

public class CabDriver {

	private String driverName;
	private Gender driverGender;
	private Integer driverAge;
	private String vehicleDetails;
	private Coordinate currentLocation;
	private Boolean isBooked;
	
	public CabDriver() {
		super();
	}

	
	public CabDriver(String driverName, Gender driverGender, Integer driverAge, String vehicleDetails,
			Coordinate currentLocation, Boolean isBooked) {
		super();
		this.driverName = driverName;
		this.driverGender = driverGender;
		this.driverAge = driverAge;
		this.vehicleDetails = vehicleDetails;
		this.currentLocation = currentLocation;
		this.isBooked = isBooked;
	}

	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public Gender getDriverGender() {
		return driverGender;
	}


	public void setDriverGender(Gender driverGender) {
		this.driverGender = driverGender;
	}


	public Integer getDriverAge() {
		return driverAge;
	}


	public void setDriverAge(Integer driverAge) {
		this.driverAge = driverAge;
	}


	public String getVehicleDetails() {
		return vehicleDetails;
	}


	public void setVehicleDetails(String vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}


	public Coordinate getCurrentLocation() {
		return currentLocation;
	}


	public void setCurrentLocation(Coordinate currentLocation) {
		this.currentLocation = currentLocation;
	}


	public boolean isBooked() {
		return isBooked;
	}


	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}


	@Override
	public String toString() {
		return "CabDriver [driverName=" + driverName + ", driverGender=" + driverGender + ", driverAge=" + driverAge
				+ ", vehicleDetails=" + vehicleDetails + ", currentLocation=" + currentLocation + ", isBooked="
				+ isBooked + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(currentLocation, driverAge, driverGender, driverName, isBooked, vehicleDetails);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CabDriver other = (CabDriver) obj;
		return Objects.equals(currentLocation, other.currentLocation) && Objects.equals(driverAge, other.driverAge)
				&& driverGender == other.driverGender && Objects.equals(driverName, other.driverName)
				&& isBooked == other.isBooked && Objects.equals(vehicleDetails, other.vehicleDetails);
	}


	

		
}
