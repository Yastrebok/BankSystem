package com.bank.system.repository;

import com.bank.system.entity.Customer;

import java.util.List;


public interface CustomerRepository {

    List<Customer> getListCustomers();
    Customer getCustomer(int id);
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
