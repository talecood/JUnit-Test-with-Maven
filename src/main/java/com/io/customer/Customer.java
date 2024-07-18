package com.io.customer;

import com.io.assertj.Gift;

import java.util.ArrayList;
import java.util.List;


public class Customer {

    private Integer id;

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getID() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
