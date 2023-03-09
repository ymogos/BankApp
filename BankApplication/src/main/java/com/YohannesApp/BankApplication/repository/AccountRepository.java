package com.YohannesApp.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.YohannesApp.BankApplication.model.Account;


public interface AccountRepository extends JpaRepository<Account,Long> {

}
