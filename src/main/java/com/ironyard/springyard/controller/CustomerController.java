package com.ironyard.springyard.controller;

import com.ironyard.springyard.model.Customer;
import com.ironyard.springyard.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index () {
        return "index";
    }

    @RequestMapping(path = "/add-customer", method = RequestMethod.GET)
    public String addCustomer () {
        return "add-customer";
    }

    @RequestMapping(path = "/view-one/{id}", method = RequestMethod.GET)
    public String viewOne (@PathVariable("id") int id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "view-one";
    }

    @RequestMapping(path = "/add-customer", method = RequestMethod.POST)
        public String createCustomer (@RequestParam(value="firstName") String firstName,
            @RequestParam(value="lastName") String lastName,
            @RequestParam(value="phone") String phone,
            @RequestParam(value="email") String email,
            Model model) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setEmail(email);
        customerService.add(customer);
        List<Customer> customersList = customerService.get();
        model.addAttribute("customers", customersList);
        return "redirect:view-customers";
    }

    @RequestMapping(path = "/view-one/{id}", method= RequestMethod.POST)
        public String goBack (Model model) {
        List<Customer> customersList = customerService.get();
        model.addAttribute("customers", customersList);
        return "redirect:/view-customers";
    }

    @RequestMapping(path = "/view-one", method = RequestMethod.POST)
        public String deleteOne (@RequestParam(value="id") int id) {
        customerService.delete(id);
        return "redirect:view-customers";
    }

    @RequestMapping(path = "/view-customers", method = RequestMethod.GET)
    public String customers (Model model) {
        List<Customer> customersList = customerService.get();
        model.addAttribute("customers", customersList);
        return "view-customers";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String logIn () {
        return "login";
    }

    @RequestMapping(path = "/loggedout", method = RequestMethod.GET)
    public String imOut () {
        return "redirect:/";
    }

    @RequestMapping(path = "/administrators", method = RequestMethod.GET)
    public String adminPage () {
        return "administrators";
    }
}
