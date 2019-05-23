package com.bank.system.repository;

import com.bank.system.entity.Transfer;

import java.util.List;

public interface TransferRepository {

    List<Transfer> getAllTransaction();

    void deposit(Transfer transfer);

}
