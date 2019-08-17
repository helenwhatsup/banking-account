package com.intern.banking.service;

import com.intern.banking.dao.ServiceDAO;
import com.intern.banking.entity.Account;
import com.intern.banking.service.BusinessException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;

@Service
public class BankingServiceImpl implements BankingService {

	@Autowired
	private ServiceDAO serviceDao;
	//private static int currentNumber = 1;

	public int openAccount(Account account) {
		System.out.println("");

		//Client c1 = new Client(name, currentNumber, new BigDecimal(balance), 1);
		serviceDao.insertNewClient(account);
		
		return account.getAccountNumber();
	}

	@Transactional(rollbackForClassName= "RuntimeException", propagation = Propagation.REQUIRED, readOnly = false)
	public void eTransfer(int from, int to, float amount) {
		Account fromClient = serviceDao.selectByNumber(from);
		Account toClient = serviceDao.selectByNumber(to);	
		
		if (fromClient.getStatus( )== 0) {
			throw new BusinessException("The bank account for the payer is closed.");
		} else if (toClient.getStatus() == 0){
			throw new BusinessException("The bank account for the payee is closed.");
		} else if (fromClient.getBalance() < amount) {
			throw new BusinessException(
					"The payer account does not have enough balance to complete this tranfer.");
		} else {
			fromClient.setBalance(fromClient.getBalance()-amount);
			toClient.setBalance(toClient.getBalance()+ amount);
			
			serviceDao.updateAccount(fromClient);
			serviceDao.updateAccount(toClient);
		}
		
	}

	@Transactional(rollbackForClassName= "RuntimeException", propagation = Propagation.REQUIRED, readOnly = false)
	public void closeAccount(int account) {
		Account c1 = serviceDao.selectByNumber(account);
		
		if (c1.getStatus() == 0) {
			throw new BusinessException("The account is already invalid.");
		} else {
			c1.setStatus(0);
			c1.setBalance(0);
			serviceDao.updateAccount(c1);
		}
	}

}