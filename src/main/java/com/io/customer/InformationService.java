package com.io.customer;

import com.io.customer.exception.MailServerUnavailableException;

public class InformationService {

	public void newSaveSendMail(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("E-Mail Sent.");
	}

	public void sendWeeklyMail() {
	throw new MailServerUnavailableException("An Error Occured in Mail Server");
	}

}
