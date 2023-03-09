package com.YohannesApp.BankApplication.service;

import java.util.List;

import com.YohannesApp.BankApplication.model.Account;


public interface AccountService {

	List<Account> getAllAccounts();
	Account getAccountById(long id);
	void saveAccount(Account account);
	
}
