package com.io.assertj;



public class CustomerService1 {

    private CustomerRepository1 customerRepository1;

    private NotificationService notificationService;

    public Customer1 handleNewCustomer(String customerName, String email) {

        Customer1 customer = new Customer1(customerName, email);

        giveWelcomeGifts(customer);
        customerRepository1.save(customer);
        notificationService.sendWelcomeNotification(customerName, email);

        return customer;
    }

    public CustomerRepository1 getCustomerRepository1() {
		return customerRepository1;
	}

	public void setCustomerRepository1(CustomerRepository1 customerRepository1) {
		this.customerRepository1 = customerRepository1;
	}

	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	private void giveWelcomeGifts(Customer1 customer) {
        customer.addGift(new Gift("welcome1"));
        customer.addGift(new Gift("welcome2"));
    }
}
