package com.intern.banking.service;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

//import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.intern.banking.dao.ServiceDAO;
import com.intern.banking.entity.Account;
import com.intern.banking.service.BusinessException;

@Service
public class ETransferServiceImpl implements ETransferService {
	 private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CloseAccountService.class);
	@Autowired
	private ServiceDAO serviceDao;
	
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
					"The payer account dos not have enough balance to complete this tranfer.");
		} else {
			fromClient.setBalance(fromClient.getBalance()-amount);
			toClient.setBalance(toClient.getBalance()+ amount);
			
			serviceDao.updateAccount(fromClient);
			serviceDao.updateAccount(toClient);
			LOGGER.info("fromCLient new amount"+fromClient+amount);
			LOGGER.info("toCLient new amount"+toClient+(-amount));
			
		}
		
	}

}
