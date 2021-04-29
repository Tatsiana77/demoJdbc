package com.tatchik.demojdbc.controller;

import com.tatchik.demojdbc.dao.CustomerDao;
import com.tatchik.demojdbc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @RequestMapping("/customers")
    public String getAllCustomer(ModelMap modelmap) {
        List<Customer> customers = customerDao.getAllCustomer();
        modelmap.addAttribute("customers", customers);
        return "customers";
    }


    @RequestMapping("/customer/edit")
    public String editCustomer(ModelMap modelMap, @RequestParam Integer id) {
        Customer customerDto = customerDao.getCustomerById(id);
        modelMap.addAttribute("customer", customerDto);
        return "editCustomer";
    }

    @RequestMapping("edit-customer")
    public String  saveCustomer(@ModelAttribute("customer" ) Customer  customer){
        customerDao.saveEntity(customer);
        return "redirect:/customers";
    }
}
