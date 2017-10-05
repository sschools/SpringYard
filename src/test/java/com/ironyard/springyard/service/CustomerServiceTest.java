package com.ironyard.springyard.service;


import com.ironyard.springyard.model.Customer;
import com.ironyard.springyard.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testAddGet() {
        String firstName = Long.toString(System.currentTimeMillis());
        String lastName = Long.toString(System.currentTimeMillis());
        String phone = Long.toString(System.currentTimeMillis());
        String email = Long.toString(System.currentTimeMillis());

        Customer cust1 = new Customer();
        cust1.setFirstName(firstName);
        cust1.setLastName(lastName);
        cust1.setPhone(phone);
        cust1.setEmail(email);
        customerRepository.add(cust1);

        List<Customer> customers = customerRepository.get();

        Customer cust2 = null;

        for (Customer c : customers) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                cust2 = c;
            }
        }

        Assert.assertNotNull(cust2);

        Customer cust3 = customerRepository.getById(cust2.getId());
        Assert.assertNotNull(cust3);
        Assert.assertEquals(firstName, cust3.getFirstName());
        Assert.assertEquals(lastName, cust3.getLastName());
    }

    @Test
    public void testUpdate() {
        String firstName = Long.toString(System.currentTimeMillis());
        String lastName = Long.toString(System.currentTimeMillis());
        String phone = Long.toString(System.currentTimeMillis());
        String email = Long.toString(System.currentTimeMillis());

        Customer cust1 = new Customer();
        cust1.setFirstName(firstName);
        cust1.setLastName(lastName);
        cust1.setPhone(phone);
        cust1.setEmail(email);
        customerRepository.add(cust1);

        List<Customer> customers = customerRepository.get();

        Customer cust2 = null;
        for (Customer c : customers) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                cust2 = c;
            }
        }
        Assert.assertNotNull(cust2);

        String updateFirstName = Long.toString(System.currentTimeMillis());
        String updateLastName = Long.toString(System.currentTimeMillis());

        cust2.setFirstName(updateFirstName);
        cust2.setLastName(updateLastName);
        customerRepository.update(cust2);

        customers = customerRepository.get();

        Customer cust3 = null;
        for (Customer c : customers) {
            if (c.getFirstName().equals(updateFirstName) && c.getLastName().equals(updateLastName)) {
                cust3 = c;
            }
        }
        Assert.assertNotNull(cust3);

        Assert.assertEquals(cust2.getId(), cust3.getId());
    }

    @Test
    public void testDelete() {
        String firstName = Long.toString(System.currentTimeMillis());
        String lastName = Long.toString(System.currentTimeMillis());
        String phone = Long.toString(System.currentTimeMillis());
        String email = Long.toString(System.currentTimeMillis());

        Customer cust1 = new Customer();
        cust1.setFirstName(firstName);
        cust1.setLastName(lastName);
        cust1.setPhone(phone);
        cust1.setEmail(email);
        customerRepository.add(cust1);

        List<Customer> customers = customerRepository.get();

        Customer cust2 = null;
        for (Customer c : customers) {
            if (c.getFirstName().equals(cust1.getFirstName()) && c.getLastName().equals(cust1.getLastName())) {
                cust2 = c;
            }
        }
        Assert.assertNotNull(cust2);

        customerRepository.delete(cust2.getId());

        customers = customerRepository.get();

        Customer cust3 = null;
        for (Customer c : customers) {
            if (c.getFirstName().equals(cust1.getFirstName()) && c.getLastName().equals(cust1.getLastName())) {
                cust3 = c;
            }
        }
        Assert.assertNull(cust3);
    }
}
