package com.tatchik.demojdbc.RestController;

import com.tatchik.demojdbc.dao.CustomerDao;
import com.tatchik.demojdbc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {

    private CustomerDao customerDao;

    @Autowired
    public CustomerRestController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("/api/customer")
    List<Customer> getAllCustomer(){
        return  customerDao.getAllCustomer();
    }
}
