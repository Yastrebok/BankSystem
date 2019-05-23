package com.bank.system.service;

import com.bank.system.entity.Account;
import com.bank.system.entity.Transfer;
import com.bank.system.repository.AccountRepository;
import com.bank.system.repository.CustomerRepository;
import com.bank.system.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<TransferDto> getAllTransaction() {
        return transferRepository.getAllTransaction().stream()
                .map(transaction -> TransferDto.builder()
                        .date(transaction.getDate())
                        .customerId(accountRepository.getAccount(transaction.getAccount()).getCustomerId())
                        .customerName(customerRepository.getCustomer(accountRepository.getAccount(transaction.getAccount())
                                .getCustomerId()).getName())
                        .account(transaction.getAccount())
                        .type(transaction.isIncrease() ? "+" : "-")
                        .value(transaction.getValue())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public TransferDto withDraw(int accountId) {
        return TransferDto.builder()
                .customerId(accountRepository.getAccount(accountId).getCustomerId())
                .customerName(customerRepository.getCustomer(accountRepository.getAccount(accountId).getCustomerId()).getName())
                .account(accountId)
                .value(accountRepository.getAccount(accountId).getQuantity())
                .build();
    }

    @Override
    public String withDraw(int accountId, double value) {
        if (accountRepository.getAccount(accountId).getQuantity() >= value) {
            transferRepository.deposit(Transfer.builder()
                    .account(accountId)
                    .increase(false)
                    .value(value)
                    .date(LocalDateTime.now())
                    .build());
            Account updatedAccount = accountRepository.getAccount(accountId);
            accountRepository.updateAccount(Account.builder()
                    .id(updatedAccount.getId())
                    .customerId(updatedAccount.getCustomerId())
                    .quantity(updatedAccount.getQuantity() - value)
                    .build());
            return "redirect:/account/customer/" + updatedAccount.getCustomerId();
        } else {
            return "error";
        }
    }

    @Override
    public TransferDto deposit(int accountId) {
        return TransferDto.builder()
                .customerId(accountRepository.getAccount(accountId).getCustomerId())
                .customerName(customerRepository.getCustomer(accountRepository.getAccount(accountId).getCustomerId()).getName())
                .account(accountId)
                .build();
    }

    @Override
    public void deposit(int accountId, double value) {
        transferRepository.deposit(Transfer.builder()
                .account(accountId)
                .increase(true)
                .value(value)
                .date(LocalDateTime.now())
                .build());
        Account updatedAccount = accountRepository.getAccount(accountId);
        accountRepository.updateAccount(Account.builder()
                .id(updatedAccount.getId())
                .customerId(updatedAccount.getCustomerId())
                .quantity(updatedAccount.getQuantity() + value)
                .build());

    }

    @Override
    public String transfer(int customerId, int account, int toAccount, double value) {
        if (accountRepository.getAccount(account).getQuantity() >= value) {
            transferRepository.deposit(Transfer.builder()
                    .account(account)
                    .increase(false)
                    .value(value)
                    .date(LocalDateTime.now())
                    .build());
            Account updatedAccount = accountRepository.getAccount(account);
            accountRepository.updateAccount(Account.builder()
                    .id(updatedAccount.getId())
                    .customerId(updatedAccount.getCustomerId())
                    .quantity(updatedAccount.getQuantity() - value)
                    .build());
            transferRepository.deposit(Transfer.builder()
                    .account(toAccount)
                    .increase(true)
                    .value(value)
                    .date(LocalDateTime.now())
                    .build());
            Account increaseAccount = accountRepository.getAccount(toAccount);
            accountRepository.updateAccount(Account.builder()
                    .id(increaseAccount.getId())
                    .customerId(increaseAccount.getCustomerId())
                    .quantity(increaseAccount.getQuantity() + value)
                    .build());
            return "redirect:/account/customer/" + increaseAccount.getCustomerId();
        } else {
            return "error";
        }
    }


}
