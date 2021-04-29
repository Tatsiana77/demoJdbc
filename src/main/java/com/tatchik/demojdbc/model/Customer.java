package com.tatchik.demojdbc.model;

public class Customer {

    private Integer id;
    private String name;
    private String surname;
    private String customer_address;
    private String customer_phone;
    private String customer_email;

    public Customer() {
    }

    public Customer(Integer id, String name, String surname,
                    String customer_address, String customer_phone, String customer_email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.customer_address = customer_address;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", customer_address='" + customer_address + '\'' +
                ", customer_phone='" + customer_phone + '\'' +
                ", customer_email='" + customer_email + '\'' +
                '}';
    }
}
