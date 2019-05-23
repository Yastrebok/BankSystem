package com.bank.system.service;

import com.bank.system.entity.Account;
import com.bank.system.repository.AccountRepository;
import com.bank.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Account> getListAccounts() {
        return accountRepository.getListAccounts();
    }

    @Override
    public List<AccountDto> getListAccountDto() {
        return accountRepository.getListAccounts().stream()
                .map(account -> AccountDto.builder()
                .id(account.getId())
                .accountCustomerId(customerRepository.getCustomer(account.getCustomerId()).getName() +  " - " + account.getId())
                .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> getListAccounts(int customerId) {
        return accountRepository.getListAccounts(customerId);
    }

    @Override
    public void createAccount(int customerId) {
        accountRepository.createAccount(Account.builder()
                .id(getLastNumberAccount() + 1)
                .customerId(customerId)
                .quantity(0.00)
                .build());
    }

    private Integer getLastNumberAccount() {
        List<Account> list = accountRepository.getListAccounts();
        if (list.isEmpty()) {
            return 262000001;
        } else {
            return list.get(list.size() - 1).getId();
        }
    }
}
