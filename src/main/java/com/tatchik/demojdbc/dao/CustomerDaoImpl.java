package com.tatchik.demojdbc.dao;

import com.tatchik.demojdbc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Customer> getCustomerWithBook() {
        String sql = "SELECT  * FROM Book  Left JOIN Customer ON Book.Customer_id = Customer.id";
        List<Customer> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class) );
        return customers;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return jdbcTemplate.query("SELECT*FROM Customer", new BeanPropertyRowMapper<>(Customer.class));
    }

    @Override
    public void saveEntity(Customer customer) {
        jdbcTemplate.update("INSERT INTO Customer VALUES (6, ?,?, ?, ?, ?)", customer.getName(), customer.getSurname(), customer.getCustomer_phone(),
                customer.getCustomer_address(), customer.getCustomer_email());

    }

    @Override
    public void updateCustomer(Integer id, Customer customer) {
        jdbcTemplate.update("UPDATE Customer SET  name =?, surname=?, customer_address =?, customer_phone=?, customer_email=? WHERE id =?",
                customer.getName(), customer.getSurname(), customer.getCustomer_address(), customer.getCustomer_phone(), customer.getCustomer_email(), id);
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE  FROM Customer WHERE id =?", id);
    }

    @Override
    public Customer getCustomerById(Integer id) {
      return   jdbcTemplate.query("SELECT*FROM Customer WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Customer.class)).stream().findAny().orElse(null);

    }
}
