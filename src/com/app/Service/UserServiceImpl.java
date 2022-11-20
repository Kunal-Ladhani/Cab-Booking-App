package com.app.Service;

import java.util.List;

import com.app.Exception.UserAlreadyExistsException;
import com.app.Exception.InvalidUserException;
import com.app.Model.User;
import com.app.Repository.UserRepository;

public class UserServiceImpl implements UserService {

	UserRepository userRepo = UserRepository.getUserRepo();
	
	@Override
	public void addUser(User user) throws UserAlreadyExistsException, InvalidUserException {
	
		if(user == null) {
			throw new InvalidUserException("INVALID USER DATA");
		}
			
			
		List<User> userList = userRepo.getUserList();
		for(User userItem : userList) {
			if(userItem == user) {
				throw new UserAlreadyExistsException("USER ALREADY EXISTS");
			}
		}
		
		userRepo.addUser(user);
	}
	
	@Override
	public void printUserList() {
		List<User> userList = userRepo.getUserList();
		
		for(User userItem : userList) {
			System.out.println(userItem);
		}
	}
	
}
