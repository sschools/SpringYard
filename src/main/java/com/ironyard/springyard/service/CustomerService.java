package com.ironyard.springyard.service;

import com.ironyard.springyard.model.Customer;

import java.util.List;

public interface CustomerService {
    void add (Customer customer);
    void update (Customer customer);
    Customer getById (int id);
    List<Customer> get();
    void delete (int id);
}
