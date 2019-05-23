package com.bank.system.repository;

import com.bank.system.entity.Account;

import java.util.List;

public interface AccountRepository {

    List<Account> getListAccounts();
    List<Account> getListAccounts(int customerId);
    Account getAccount(int id);
    void createAccount(Account account);
    void updateAccount(Account account);

}
