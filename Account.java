package com.intern.banking.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable {
	private int accountNumber;
	private String name;
	private float balance;
	private int status;	
	
	private static final long serialVersionUID = 20190617095055L;
	
	public Account() {}

	public Account(int accountNumber, String name, float balance, int status) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.status = status;
	}

	public String getClientName() {
		return name;
	}

	public void setClientName(String clientName) {
		this.name = clientName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
