package com.io.unittest.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.io.assertj.CustomerRepository1;
import com.io.assertj.CustomerService1;
import com.io.assertj.NotificationService;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {
	
	/*@Spy
	private DummyCustomerService dummyCustomerService;*/
	
	/*@Before
	public void setUp() throws Exception{
		dummyCustomerService = Mockito.mock(DummyCustomerService.class);
	}*/
	
	@InjectMocks
	private CustomerService1 customerService;
	
	@Mock
	private CustomerRepository1 customerRepository1;
	
	@Mock
	private NotificationService notificationService;

	@Test
	public void testAnnotation() throws Exception{
		
		customerService.handleNewCustomer("name","email");
		
	}
}
