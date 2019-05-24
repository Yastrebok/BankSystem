package com.bank.system.service;

import com.bank.system.entity.Account;
import com.bank.system.entity.Customer;
import com.bank.system.repository.AccountRepository;
import com.bank.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<CustomerDto> getListCustomers() {
        return customerRepository.getListCustomers().stream()
                .map(customer ->
                        CustomerDto.builder()
                                .customerId(customer.getId())
                                .customerName(customer.getName())
                                .address(customer.getAddress())
                                .age(customer.getAge())
                                .sum(accountRepository.getListAccounts(customer.getId())
                                        .stream()
                                        .mapToDouble(Account::getQuantity)
                                        .sum())
                                .build())
                .collect(Collectors.toList());
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
