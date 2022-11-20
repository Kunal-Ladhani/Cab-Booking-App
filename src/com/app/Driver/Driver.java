package com.app.Driver;

import java.util.List;

import com.app.Exception.CabDriverAlreadyExistsException;
import com.app.Exception.InvalidCabDriverException;
import com.app.Exception.InvalidCoordinatesException;
import com.app.Exception.InvalidUserException;
import com.app.Exception.UserAlreadyExistsException;
import com.app.Exception.UserNotFoundException;
import com.app.Model.CabDriver;
import com.app.Model.Coordinate;
import com.app.Model.Gender;
import com.app.Model.User;
import com.app.Repository.CabDriverRepository;
import com.app.Repository.UserRepository;
import com.app.Service.CabDriverService;
import com.app.Service.CabDriverServiceImpl;
import com.app.Service.RideService;
import com.app.Service.RideServiceImpl;
import com.app.Service.UserService;
import com.app.Service.UserServiceImpl;

public class Driver {
	
	public static void main(String[] args) throws UserAlreadyExistsException, InvalidUserException, CabDriverAlreadyExistsException, InvalidCabDriverException, UserNotFoundException, InvalidCoordinatesException {
		
	/* ============================== USER DRIVER CODE ============================ */	
		UserService userService = new UserServiceImpl();
		
		User user1 = new User("Rohit",Gender.MALE, 28);
		User user2 = new User("Abhishek", Gender.MALE, 23);
		User user3 = new User("Rahul" , Gender.MALE, 29);
		User user4 = new User("Nandini", Gender.FEMALE, 22);

		userService.addUser(user1);
		userService.addUser(user2);
		userService.addUser(user3);
		userService.addUser(user4 );
		
		userService.printUserList();

		System.out.println("==============================================");

	/* ========================== CAB-DRIVER DRIVER CODE ========================== */
		CabDriverService cabDriverService = new CabDriverServiceImpl();
		
		CabDriver driver1 = new CabDriver("Mohan",Gender.MALE,35,"Swift, KA-01-12345",new Coordinate(10,1),false);
		CabDriver driver2 = new CabDriver("Dilip",Gender.MALE,35,"Swift, KA-01-12345",new Coordinate(10,9),false);
		CabDriver driver3 = new CabDriver("Rajesh",Gender.MALE,35,"Swift, KA-01-12345",new Coordinate(5,3),false);
		
		
		cabDriverService.addCabDriver(driver1);
		cabDriverService.addCabDriver(driver2);
		cabDriverService.addCabDriver(driver3);
		
		cabDriverService.printCabDriverList();

		System.out.println("==============================================");

	
	/* ========================== RIDE DRIVER CODE ========================== */
		
		RideService rideService = new RideServiceImpl();
		
		List<CabDriver> rides = rideService.findRide("nandini", new Coordinate(15,6), new Coordinate(20,4));
		
		if(rides == null || rides.isEmpty()) {
			System.out.println("NO RIDES AVAILABLE IN AREA");
		}
		
		for(CabDriver ride : rides) {
			System.out.println(ride);
		}
		
		
		rideService.ChooseRide("abhishek", rides, "dilip");
		
		
		System.out.println("==============================================");

	}
}
