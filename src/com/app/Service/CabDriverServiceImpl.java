package com.app.Service;

import java.util.List;

import com.app.Exception.CabDriverAlreadyExistsException;
import com.app.Exception.InvalidCabDriverException;
import com.app.Model.CabDriver;
import com.app.Repository.CabDriverRepository;

public class CabDriverServiceImpl implements CabDriverService {

	CabDriverRepository cabDriverRepo = CabDriverRepository.getCabDriverRepo();
	
	@Override
	public void addCabDriver(CabDriver cabDriver)
			throws CabDriverAlreadyExistsException, InvalidCabDriverException {
		
		if(cabDriver == null)
			throw new InvalidCabDriverException("INVALID CAB DRIVER DATA");
		
		List<CabDriver> cabDriverList = cabDriverRepo.getCabDriverList();
		
		for(CabDriver driver : cabDriverList) {
			if(driver == cabDriver)
				throw new CabDriverAlreadyExistsException("DUPLICATE CAB DRIVER");
		}
		
		cabDriverList.add(cabDriver);
	}

	@Override
	public void printCabDriverList() {
		
		List<CabDriver> cabDriverList = cabDriverRepo.getCabDriverList();
		
		for(CabDriver driver : cabDriverList) {
			System.out.println(driver);
		}
		
	}

}
