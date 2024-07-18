package com.io.customer;

import com.io.assertj.Customer1;

public class CustomerRepository {

	public void save(Customer customer) {
		System.out.println("Customer saved.");
	}
	public void delete(int customerID) {
		System.out.println("Customer deleted.");
	}
	
}
