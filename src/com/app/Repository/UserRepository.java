package com.app.Repository;

import java.util.ArrayList;
import java.util.List;

import com.app.Model.User;

public class UserRepository {
	
	private static UserRepository userRepo = new UserRepository();
	private static List<User> userList = new ArrayList<>();
	
	private UserRepository() {
		super();
	}
	

	public static UserRepository getUserRepo() {
		return userRepo;
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public void addUser(User user) {
		this.userList.add(user);
	}
	
}
