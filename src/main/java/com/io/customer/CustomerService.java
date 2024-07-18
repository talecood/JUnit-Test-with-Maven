package com.io.customer;

public class CustomerService {

	private CustomerRepository customerRepository;
	
	private InformationService 	informationService;
	
	public void saveCustomer(Customer customer) {
	customerRepository.save(customer);
	informationService.newSaveSendMail(customer);
	}
	public void deleteCustomer(int customerID) {
		customerRepository.delete(customerID);
	}


	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
}
