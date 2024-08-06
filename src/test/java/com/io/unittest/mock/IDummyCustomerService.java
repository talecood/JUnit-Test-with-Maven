package com.io.unittest.mock;

public interface IDummyCustomerService {

	public void addCustomer(String custName);
	
	public void removeCustomer(String custName);
	
	public void updateCustomer(String custName);
	
	public String getCustomer(String custName);
}
