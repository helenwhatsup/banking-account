package com.intern.banking;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
//import java.math.BigDecimal;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intern.banking.entity.Account;
import com.intern.banking.service.BankingService;;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:conf/applicationContext.xml"})
public class BankingServiceImplTest {
//	@Autowired
//	BankingService  BankingService;
	
//	@BeforeClass
//	public static void before() {
//		org.springframework.context.ApplicationContext context = new ClassPathXmlApplicationContext(
//				"conf/applicationContext.xml");
//		BankingServiceImpl  BankingServiceImpl = (BankingServiceImpl) context.getBean("BankingServiceImpl");
//	}
//
//	@Test
//	public void testOpenAccount() {
//	        Client c1 = new Client(4, "max", 500, 1);
//			int n = BankingService.openAccount(c1);
//			System.out.println(n);
//			assertEquals(1, n);
//	}
//	
//	@Test
//	public void testETransfer() {
//		BankingService.eTransfer(1, 2, 20);
//	}
//	
//	@Test
//	public void testCloseAccount() {
//		BankingService.closeAccount(1);
//	}
}
