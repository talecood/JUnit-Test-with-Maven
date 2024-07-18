package com.io.assertj;

import java.util.ArrayList;
import java.util.List;


public class Customer1 {

    private String username;

    private String email;

    private List<Gift> gifts = new ArrayList<Gift>();

    public void addGift(Gift gift) {
        gifts.add(gift);
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Gift> getGifts() {
		return gifts;
	}

	public void setGifts(List<Gift> gifts) {
		this.gifts = gifts;
	}

	public Customer1(String username, String email) {
        this.username = username;
        this.email = email;
    }

}