package com.intern.banking.dao;


import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.intern.banking.entity.Account;

//@Component
@Service()
public interface ServiceDAO {
	int insertNewClient(Account account);

	Account selectByNumber(int accountNumber);

	int updateAccount(Account account);

}
