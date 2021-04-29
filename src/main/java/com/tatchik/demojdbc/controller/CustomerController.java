package com.tatchik.demojdbc.controller;

import com.tatchik.demojdbc.dao.CustomerDao;
import com.tatchik.demojdbc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }



    @RequestMapping(value = "/customers", method =  RequestMethod.GET)
    public String getAllCustomer(ModelMap modelmap) {
        List<Customer> customer = customerDao.getAllCustomer();
        modelmap.addAttribute("customers", customer);
        return "customer";
    }


    @RequestMapping(value = "/customer/edit", method = RequestMethod.POST)
    public String editCustomer(ModelMap modelMap, @RequestParam Integer id) {
        Customer customer = customerDao.getCustomerById(id);
        modelMap.addAttribute("customer", customer);
        return "edit_Customer";
    }

    @RequestMapping(value = "edit-customer", method = RequestMethod.POST)
    public String  saveCustomer(@ModelAttribute("customer" ) Customer  customer){
        customerDao.saveEntity(customer);
        return "redirect:/customers";
    }
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newCustomer(List<Customer > customerList)  {
        Customer customer = new Customer();
        customerList.add(Integer.parseInt("customer"), customer);
        return "new_customer";
    }
}
