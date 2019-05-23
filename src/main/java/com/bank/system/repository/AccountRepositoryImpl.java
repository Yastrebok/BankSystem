package com.bank.system.repository;

import com.bank.system.entity.Account;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AccountRepositoryImpl extends AbstractRepository<Integer, Account> implements AccountRepository {

    @Override
    public List<Account> getListAccounts() {
        return getList();
    }

    @Override
    public List<Account> getListAccounts(int customerId) {
        return getListByCustomer(customerId);
    }

    @Override
    public Account getAccount(int id) {
        return getById(id);
    }

    @Override
    public void createAccount(Account account) {
        save(account);
    }

    @Override
    public void updateAccount(Account account) {
        update(account);
    }

}
