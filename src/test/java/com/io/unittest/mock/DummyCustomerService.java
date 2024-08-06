package com.io.unittest.mock;

public class DummyCustomerService implements IDummyCustomerService{

	@Override
	public void addCustomer(String custName) {
		// TODO Auto-generated method stub
		System.out.println("addCustomer(" + custName + ")");
	}

	@Override
	public void removeCustomer(String custName) {
		// TODO Auto-generated method stub
		System.out.println("removeCustomer(" + custName + ")");
	}

	@Override
	public void updateCustomer(String custName) {
		// TODO Auto-generated method stub
		System.out.println("updateCustomer(" + custName + ")");
	}

	@Override
	public String getCustomer(String custName) {
		return "getCustomer(" + custName + ")";
	}

	
}
