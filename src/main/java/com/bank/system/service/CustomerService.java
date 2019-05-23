package com.bank.system.service;

import com.bank.system.entity.Account;
import com.bank.system.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



public interface CustomerService {

    List<Customer> getListCustomers();

    Customer getCustomer(int id);

    void createCustomer(String name, String address, int age);

    void updateCustomer(int id, String name, String address, int age);

    void deleteCustomer(int id);


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CustomerDto {
        private int customerId;
        private String customerName;
        private String address;
        private int age;
        private List<Account> listAccounts;
    }
}
