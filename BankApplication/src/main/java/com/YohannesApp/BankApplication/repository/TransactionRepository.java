package com.YohannesApp.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.YohannesApp.BankApplication.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{

}
