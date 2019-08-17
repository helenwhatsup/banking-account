package com.intern.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.banking.dao.ServiceDAO;
import com.intern.banking.entity.Account;

@Service
public class OpenAccountServiceImpl implements OpenAccountService {
	@Autowired
	private ServiceDAO serviceDao;

	public int openAccount(Account account) {
		System.out.println("");

		serviceDao.insertNewClient(account);
		
		return account.getAccountNumber();
	}

}
