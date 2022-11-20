package com.app.Service;

import com.app.Exception.UserAlreadyExistsException;

import java.util.List;

import com.app.Exception.InvalidUserException;
import com.app.Model.User;
import com.app.Repository.UserRepository;

public interface UserService {
	public void addUser(User user) throws UserAlreadyExistsException, InvalidUserException;

	public void printUserList();
}
