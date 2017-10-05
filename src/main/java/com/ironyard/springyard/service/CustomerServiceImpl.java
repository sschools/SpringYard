package com.ironyard.springyard.service;

import com.ironyard.springyard.model.Customer;
import com.ironyard.springyard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Transactional
    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.getById(id);
    }

    @Override
    public List<Customer> get() {
        return customerRepository.get();
    }

    @Transactional
    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }
}
