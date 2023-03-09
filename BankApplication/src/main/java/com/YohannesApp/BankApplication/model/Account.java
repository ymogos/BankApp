package com.YohannesApp.BankApplication.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")

public class Account {
	
public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
@Column(name = "accountType")
private String accountType;

@Column(name = "balance")
private double balance;

@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
private List<Transaction> transactions;

@ManyToOne
@JoinColumn(name = "user_id")
private User user;

public Account() {
	super();

}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
}



public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}


}
