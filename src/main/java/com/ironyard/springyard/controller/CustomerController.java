package com.ironyard.springyard.controller;

import com.ironyard.springyard.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(path = "/view-customers", method = RequestMethod.GET)
    public String customers () {
        return "view-customers";
    }
}
