package com.bank.system.repository;

import com.bank.system.entity.Transfer;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransferRepositoryImpl extends AbstractRepository<Integer, Transfer> implements TransferRepository {

    @Override
    public List<Transfer> getAllTransaction() {
        return getList();
    }

    @Override
    public void deposit(Transfer transfer) {
        save(transfer);
    }
}
