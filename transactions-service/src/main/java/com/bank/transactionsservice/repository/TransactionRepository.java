package com.bank.transactionsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bank.transactionsservice.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, Integer>{

}
