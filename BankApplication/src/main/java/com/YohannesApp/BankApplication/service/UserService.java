package com.YohannesApp.BankApplication.service;

import java.util.List;

import com.YohannesApp.BankApplication.model.User;



public interface UserService {
	List<User> getAllUsers();
	User getUserById(long id);
	void saveUser(User user);
	User login(User user);

}
