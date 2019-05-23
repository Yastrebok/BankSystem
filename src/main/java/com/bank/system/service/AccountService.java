package com.bank.system.service;

import com.bank.system.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public interface AccountService {

    List<Account> getListAccounts();

    List<AccountDto> getListAccountDto();

    List<Account> getListAccounts(int customerId);

    void createAccount(int customerId);

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class AccountDto {
        private int id;
        private String accountCustomerId;

    }

}
