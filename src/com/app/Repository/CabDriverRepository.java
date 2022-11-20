package com.app.Repository;

import java.util.ArrayList;
import java.util.List;

import com.app.Model.CabDriver;

public class CabDriverRepository {
	
	private static CabDriverRepository cabDriverRepo = new CabDriverRepository();
	private static List<CabDriver> cabDriverList = new ArrayList<>();
	
	private CabDriverRepository() {}

	public static CabDriverRepository getCabDriverRepo() {
		return cabDriverRepo;
	}
	
	public List<CabDriver> getCabDriverList() {
		return cabDriverList;
	}

	public void setCabDriverList(List<CabDriver> cabDriverList) {
		this.cabDriverList = cabDriverList;
	}

	private void addCabDriver(CabDriver cabDriver) {
		this.cabDriverList.add(cabDriver);
	}
	
}
