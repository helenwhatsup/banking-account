package com.intern.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.intern.banking.dao.ServiceDAO;
import com.intern.banking.entity.Account;
import com.intern.banking.service.BusinessException;

@Service
public class CloseAccountServiceImpl implements CloseAccountService{
	  private static final Logger LOGGER = LoggerFactory.getLogger(CloseAccountService.class);
	@Autowired
	private ServiceDAO serviceDao;
	
	@Transactional(rollbackForClassName= "RuntimeException", propagation = Propagation.REQUIRED, readOnly = false)
	public void closeAccount(int account) {
		Account c1 = serviceDao.selectByNumber(account);
		
		if (c1.getStatus() == 0) {
			throw new BusinessException("The account is already invalid.");
		} else {
			c1.setStatus(0);
			c1.setBalance(0);
			serviceDao.updateAccount(c1);
			LOGGER.info("account");
			
		}
	}
}
