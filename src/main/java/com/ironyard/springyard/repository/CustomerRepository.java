package com.ironyard.springyard.repository;

import com.ironyard.springyard.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
