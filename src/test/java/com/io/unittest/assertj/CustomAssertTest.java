package com.io.unittest.assertj;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.io.assertj.Customer1;
import com.io.assertj.CustomerRepository1;
import com.io.assertj.CustomerService1;
import com.io.assertj.NotificationService;

import junit.framework.Assert;
import com.io.unittest.assertj.custom.*;


public class CustomAssertTest {

	private CustomerRepository1 customerRepository;
	private NotificationService notificationService;
	private CustomerService1 customerService;
	
	public static final String USERNAME = "talecood";
	public static final String EMAIL = "g@ktug.com";
	
	
	@Before
	public void setUp() throws Exception{
		customerService = new CustomerService1();
		customerRepository = Mockito.mock(CustomerRepository1.class);
		notificationService = Mockito.mock(NotificationService.class);
		
		customerService.setCustomerRepository1(customerRepository);
		customerService.setNotificationService(notificationService);
	}
	
	@Test
	public void testCustomerAssertsJUnit() throws Exception{
		Customer1 customer = customerService.handleNewCustomer(USERNAME, EMAIL);
		
		Mockito.verify(notificationService).sendWelcomeNotification(USERNAME, EMAIL);
		
		Mockito.verify(customerRepository).save(Mockito.any(Customer1.class));
		Assert.assertNotNull(customer.getGifts());
		Assert.assertEquals(2,customer.getGifts().size());
		
		Assert.assertEquals("welcome1", customer.getGifts().get(0).getName());
		Assert.assertEquals("welcome2", customer.getGifts().get(1).getName());
	
		
	}
	@Test
	public void testCustomAssertJ() throws Exception{
		Customer1 customer = customerService.handleNewCustomer(USERNAME, EMAIL);
		
		((CustomerAssert) ((CustomerAssert) ((CustomerAssert) assertThatCustomer(customer)
			.isNotNull()
			.isSaved())
			.hasReceivedNotification())
			.hasGifts(2)
			.hasGiftWithName("welcome1"))
			.hasGiftWithName("welcome2");
	}
	private CustomerAssert assertThatCustomer(Customer1 customer) {
		return new CustomerAssert(customer,CustomerAssert.class, customerRepository, notificationService);
	}
	
}

















