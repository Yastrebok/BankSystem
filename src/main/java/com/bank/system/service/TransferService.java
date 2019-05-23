package com.bank.system.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferService {

    List<TransferDto> getAllTransaction();

    TransferDto withDraw(int accountId);

    String withDraw(int accountId, double value);

    TransferDto deposit(int accountId);

    void deposit(int accountId, double value);

    String transfer(int customerId, int account, int toAccount, double value);

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class TransferDto {

        private int customerId;
        private String customerName;
        private int account;
        private String type;
        private double value;
        private LocalDateTime date;
    }
}
