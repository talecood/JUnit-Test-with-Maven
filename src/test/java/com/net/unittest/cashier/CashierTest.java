package com.net.unittest.cashier;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.net.cashier.*;

class CashierTest {

	private Cashier cashier;
	
	@Test
	public void validateTransactionThrowsIllegalArgument() {
		
		assertThrows(IllegalArgumentException.class, ()->cashier.validateTransaction("USD",10));
	}
	
	@Test
	public void validateTransactionThrowsInvalidTransaction() {
		assertThrows(InvalidTransactionAmountException.class,()->cashier.validateTransaction("GBP", -10));
	}

	
}
