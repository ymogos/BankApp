package com.YohannesApp.BankApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.YohannesApp.BankApplication.model.Account;
import com.YohannesApp.BankApplication.model.User;
import com.YohannesApp.BankApplication.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService{
	@Autowired
	private AccountRepository accountsRepository;
	
 
	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountsRepository.findAll();
	}

	@Override
	public Account getAccountById(long id) {
		// TODO Auto-generated method stub
		java.util.Optional<Account> optional = accountsRepository.findById(id);
		   Account acc = null;
		   if(optional.isPresent()) {
			   acc = optional.get();
		   } else {
			   throw new RuntimeException("Account not found for id: "+ id);
			   
		   }
		   return acc;
		
	}

	@Override
	public void saveAccount(Account accounts) {
		this.accountsRepository.save(accounts);
		
	}

}
