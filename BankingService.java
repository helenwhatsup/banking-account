package com.intern.banking.service;

import com.intern.banking.entity.Account;

public interface BankingService {
	public int openAccount(Account account);
	
	public void eTransfer(int from, int to, float amount);
	
	public void closeAccount(int account);
	
}
