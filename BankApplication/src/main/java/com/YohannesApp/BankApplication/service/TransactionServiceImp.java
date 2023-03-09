package com.YohannesApp.BankApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YohannesApp.BankApplication.model.Transaction;
import com.YohannesApp.BankApplication.repository.TransactionRepository;

@Service
public class TransactionServiceImp implements TransactionService{
  
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> getTransactionByAccoumt(long id) {
	
		return null;
	}

	@Override
	public void saveTransaction(Transaction trans) {
		// TODO Auto-generated method stub
		this.transactionRepository.save(trans);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}

}
