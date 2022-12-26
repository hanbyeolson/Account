package com.zerobase.demo.repository;

import com.zerobase.demo.domain.Account;
import com.zerobase.demo.domain.AccountUser;
import com.zerobase.demo.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByTransactionId(String transactionId);
}
