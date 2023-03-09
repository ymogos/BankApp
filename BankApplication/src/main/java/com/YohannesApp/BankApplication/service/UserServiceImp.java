package com.YohannesApp.BankApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.YohannesApp.BankApplication.model.User;
import com.YohannesApp.BankApplication.repository.UserRepository;

import java.util.List;



@Service
public class UserServiceImp implements  UserService  {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
	
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);
		
	}

	@Override
	public User getUserById(long id) {
		java.util.Optional<User> optional = userRepository.findById(id);
	   User user = null;
	   if(optional.isPresent()) {
		   user = optional.get();
	   } else {
		   throw new RuntimeException("Employee not found for id: "+ id);
		   
	   }
	   return user;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		java.util.Optional<User> optional = userRepository.findByEmail(user.getEmail());
		 User user1 = null;
		 
		
	
		 if(optional.isPresent()) {
			   user1 = optional.get();
				System.out.print(user1.getEmail());
		   } else {
			   throw new RuntimeException("User not found for id: ");
			   
		   }
		 
		 return user1;
		  
	}

	

	
}
