package com.vlsystem.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlsystem.picpay.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
