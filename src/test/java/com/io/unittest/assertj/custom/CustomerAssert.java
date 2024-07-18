package com.io.unittest.assertj.custom;

import com.io.assertj.*;
import org.assertj.core.api.AbstractAssert;
import org.mockito.Mockito;

import com.io.assertj.Customer1;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerAssert extends AbstractAssert<CustomerAssert,Customer1>{

	CustomerRepository1 customerRepository;
	NotificationService notificationService;
	
	
	public CustomerAssert(Customer1 actual, Class<?> selfType,CustomerRepository1 customerRepository,NotificationService notificationService) {
		super(actual, selfType);
		
		this.customerRepository = customerRepository;
		this.notificationService = notificationService;
		isNotNull();
	}

	public CustomerAssert hasGifts(int sizeOfGifts) {
		// TODO Auto-generated method stub
		assertThat(actual.getGifts())
			.isNotEmpty()
			.hasSize(sizeOfGifts);
		
		
		return this;
	}

	public Object hasGiftWithName(String string) {
		assertThat(actual.getGifts())
			.isNotEmpty()
			.extracting("name");
		
		return this;
	}

	public Object isSaved() {
		
		Mockito.verify(customerRepository).save(Mockito.any(Customer1.class));
		
		return this;
		
	}
	
	public Object hasReceivedNotification() {
		Mockito.verify(notificationService).sendWelcomeNotification(Mockito.anyString(),Mockito.anyString());
		
		return this;
	}
	

	
}
