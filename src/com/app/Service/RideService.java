package com.app.Service;

import java.util.List;

import com.app.Exception.InvalidCabDriverException;
import com.app.Exception.InvalidCoordinatesException;
import com.app.Exception.InvalidUserException;
import com.app.Exception.UserNotFoundException;
import com.app.Model.CabDriver;
import com.app.Model.Coordinate;

public interface RideService {
	
	public List<CabDriver> findRide(String username, Coordinate source, Coordinate destination) throws InvalidUserException, UserNotFoundException, InvalidCoordinatesException;
	
	public void ChooseRide(String username, List<CabDriver> rides, String driverName) throws InvalidCabDriverException, InvalidUserException, UserNotFoundException;

}
