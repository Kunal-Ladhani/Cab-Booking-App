package com.app.Service;

import com.app.Exception.CabDriverAlreadyExistsException;
import com.app.Exception.InvalidCabDriverException;
import com.app.Exception.InvalidUserException;
import com.app.Exception.UserAlreadyExistsException;
import com.app.Model.CabDriver;
import com.app.Repository.CabDriverRepository;

public interface CabDriverService {
	
	public void addCabDriver(CabDriver cabDriver) throws CabDriverAlreadyExistsException, InvalidCabDriverException;

	public void printCabDriverList();

}
