package com.YohannesApp.BankApplication.service;

import java.util.List;

import com.YohannesApp.BankApplication.model.Account;
import com.YohannesApp.BankApplication.model.Transaction;

public interface TransactionService {
	List<Transaction> getAllTransactions();
	List<Transaction> getTransactionByAccoumt(long id);
	void saveTransaction(Transaction trans);
}
