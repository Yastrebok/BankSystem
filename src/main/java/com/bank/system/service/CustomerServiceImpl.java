package com.bank.system.service;

import com.bank.system.entity.Customer;
import com.bank.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getListCustomers() {
        return customerRepository.getListCustomers();
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    public void createCustomer(String name, String address, int age) {
        customerRepository.createCustomer(Customer.builder()
                .id(0)
                .name(name)
                .address(address)
                .age(age)
                .build());
    }

    @Override
    public void updateCustomer(int id, String name, String address, int age) {
        customerRepository.updateCustomer(Customer.builder()
                .id(id)
                .name(name)
                .address(address)
                .age(age)
                .build());
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(customerRepository.getCustomer(id));
    }
}
