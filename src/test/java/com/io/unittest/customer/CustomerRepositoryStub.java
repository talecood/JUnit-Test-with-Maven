package com.io.unittest.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.io.customer.Customer;
import com.io.customer.CustomerRepository;

public class CustomerRepositoryStub extends CustomerRepository{

	private Map<Integer,Customer> customerList = new HashMap<Integer,Customer>();
	
	@Override
	public void save(Customer customer) {
		customerList.put(customer.getID(),customer);
	}
	@Override
	public void delete(int customerID){
		customerList.remove(customerID);
	}
	public Map<Integer,Customer> getCustomerList(){
		return customerList;	
	}
}
