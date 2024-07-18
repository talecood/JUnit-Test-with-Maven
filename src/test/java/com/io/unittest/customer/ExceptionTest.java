package com.io.unittest.customer;

import static org.assertj.core.api.Assertions.catchException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionHamcrestMatchers.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.io.customer.InformationService;
import com.io.customer.exception.MailServerUnavailableException;

public class ExceptionTest {

	private InformationService informationService = new InformationService();
	
	
	//First Way
	@Test 
	public void testTryCatchException() {
		try {
			informationService.sendWeeklyMail();
		}catch (Exception ex) {
			assertTrue(ex instanceof MailServerUnavailableException);
			assertEquals("An Error Occured in Mail Server",ex.getMessage());
		}
	}
	
	//Second Way - No way to control exception message.
	@Test(expected = MailServerUnavailableException.class)
	public void testExpectedException() throws Exception{
		informationService.sendWeeklyMail();
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	public void testRuleException() throws Exception{
		thrown.expect(MailServerUnavailableException.class);
		thrown.expectMessage("An Error Occured in Mail Server");
		
		informationService.sendWeeklyMail();
	}	
	@Test  //https://code.google.com/archive/p/catch-exception/ Framework
	public void testCatchExpectionFramework() throws Exception{
		
		catchException(informationService).sendWeeklyMail();
		
		 assertTrue(caughtException() instanceof MailServerUnavailableException);
	     assertEquals("An Error Occured in Mail Server", caughtException().getMessage());
		
		
	}
}
