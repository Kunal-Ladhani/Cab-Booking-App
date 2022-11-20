package com.app.Service;

import java.util.ArrayList;
import java.util.List;

import com.app.Exception.InvalidCabDriverException;
import com.app.Exception.InvalidCoordinatesException;
import com.app.Exception.InvalidUserException;
import com.app.Exception.UserNotFoundException;
import com.app.Model.CabDriver;
import com.app.Model.Coordinate;
import com.app.Model.User;
import com.app.Repository.CabDriverRepository;
import com.app.Repository.UserRepository;

public class RideServiceImpl implements RideService {

	UserRepository userRepo = UserRepository.getUserRepo();
	
	CabDriverRepository cabDriverRepo = CabDriverRepository.getCabDriverRepo();
	
	/* FOR CHECKING IS DRIVER IN 5 UNITS OF RADIUS */
	private boolean isAvailable(CabDriver driver, Coordinate source) {
		boolean availability = false;
		
		Coordinate cabD = driver.getCurrentLocation(); 
		double dist = 0.0d;
		
		dist = Math.sqrt(Math.pow(cabD.getX() - source.getX() , 2) + Math.pow(cabD.getY() - source.getY() , 2));
		
		if(dist <= 5.0)
			availability = true;
		
		return availability;
	}
	
	@Override
	public List<CabDriver> findRide(String username, Coordinate source, Coordinate destination) throws InvalidUserException, UserNotFoundException, InvalidCoordinatesException {
		
		if(username.trim() == "" || username == null)
			throw new InvalidUserException("INVALID USER DATA");
		
		if(source == null || destination == null)
			throw new InvalidCoordinatesException("INVALID COORDINATES SPECIFIED");
			
		boolean userFound = false;
		List<User> userList = userRepo.getUserList();
		for(User userItem : userList) {
			if(userItem.getUserName().equalsIgnoreCase(username)) {
				userFound = true;
				break;
			}
		}
		if(userFound == false) {
			throw new UserNotFoundException("USER NOT PRESENT");			
		}
		
		List<CabDriver> rides = new ArrayList<>();
		
		List<CabDriver> driverList = cabDriverRepo.getCabDriverList();
		
		for(CabDriver driver : driverList) {
			if(driver.isBooked() == false && isAvailable(driver,source) == true) {
				rides.add(driver);
			}
		}
		
		return rides;
	}

	@Override
	public void ChooseRide(String username, List<CabDriver> rides ,String driverName) throws InvalidCabDriverException, InvalidUserException, UserNotFoundException {
		
		if(driverName == null || driverName.trim() == "")
			throw new InvalidCabDriverException("INVALID DRIVERN NAME");
		
		if(username == null || username.trim() == "")
			throw new InvalidUserException("INVALID USER NAME");
		
		boolean userFound = false;
		List<User> userList = userRepo.getUserList();
		for(User userItem : userList) {
			if(userItem.getUserName().equalsIgnoreCase(username)) {
				userFound = true;
				break;
			}
		}
		if(userFound == false) {
			throw new UserNotFoundException("USER NOT PRESENT");			
		}
		
		for(CabDriver ride : rides) {
			if(ride.isBooked() == false && ride.getDriverName().equalsIgnoreCase(driverName)) {
				ride.setBooked(true);
				System.out.println("Ride Booked!");
				System.out.println("Driver Details => "+ride);
				return ;
			}
		}
		
		System.out.println("RIDE NOT BOOKED");
	}

}
