package com.infosys.anz.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.anz.entity.AccountsEntity;
import com.infosys.anz.entity.TransactionsEntity;
import com.infosys.anz.repository.TransactionsRepository;
import com.infosys.anz.service.TransactionsService;

@RunWith(SpringRunner.class)
public class TransactionsControllerTest_Pass {

	@InjectMocks
	private TransactionsService transService;
	
	@Mock
	private TransactionsRepository transRepo;
	
	 @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	 
	@Test
	void viewAccountTransactionsTest() {
		
		//fail("Not yet implemented");
		
		AccountsEntity account = new AccountsEntity();
		account.setAccountNumber("1232223212");
		List<TransactionsEntity> list = new ArrayList<TransactionsEntity>();
		TransactionsEntity trans1 = new TransactionsEntity();
		trans1.setAccountNumber(account.getAccountNumber());
		trans1.setAccountName("Current Account");
		trans1.setCreditAmount(9540.96);
		trans1.setCurrency("SGD");
		trans1.setDebitOrCredit("Credit");
		trans1.setValueDate("Jan 12,2012");
		
		TransactionsEntity trans2 = new TransactionsEntity();
		trans2.setAccountNumber(account.getAccountNumber());
		trans2.setAccountName("Current Account");
		trans2.setCreditAmount(7497.82);
		trans2.setCurrency("SGD");
		trans2.setDebitOrCredit("Credit");
		trans2.setValueDate("Jan 12,2012");
		
		list.add(trans1);
		list.add(trans2);
		
		when(transRepo.findAll()).thenReturn(list);
		
		List<TransactionsEntity> accList = transService.viewAccountTransactions(account.getAccountNumber());
		
		assertEquals(2,accList.size());
		
		verify(transRepo,times(1)).findAll();
		
		//assertNotEquals(3,accList.size());
		
		
	}

}
