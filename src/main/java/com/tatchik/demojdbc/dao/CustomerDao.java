package com.tatchik.demojdbc.dao;

import com.tatchik.demojdbc.model.Customer;

import java.util.List;


public interface CustomerDao {




    public List<Customer> getCustomerWithBook();

    public List<Customer> getAllCustomer();

    public void saveEntity(Customer customer);

    public void updateCustomer(Integer id, Customer customer);

    public void deleteById(Integer id);

    Customer getCustomerById(Integer id);
}
