package com.io.unittest.customer;

import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import com.io.customer.Customer;
import com.io.customer.CustomerRepository;
import com.io.customer.CustomerService;
import com.io.customer.InformationService;

class CustomerServiceTest {
	
	private CustomerService customerService;
	
	private CustomerRepository customerRepository;
	
	private InformationService informationService;

	@BeforeEach
	public void setUp() throws Exception{
		customerService = new CustomerService();
		customerRepository = Mockito.mock(CustomerRepository.class);
		informationService = Mockito.mock(InformationService.class);
		
		customerService.setCustomerRepository(customerRepository);
		customerService.setInformationService(informationService);
	}
	
	@Test
	public void testCustomerSave() {
		Customer customer = new Customer(78);
		
		customerService.saveCustomer(customer);
		
//      verify that a specific behavior has occurred according to a specified verification mode
		Mockito.verify(informationService).newSaveSendMail(customer);
		Mockito.verify(customerRepository).save(customer);
		
	
	}

}
