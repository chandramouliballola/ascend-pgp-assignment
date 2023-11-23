package com.bank.transactionsservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.transactionsservice.model.Transaction;
import com.bank.transactionsservice.repository.TransactionRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	@Autowired
	private TransactionRepository repository;
	
	@PostMapping("/postTransaction")
	public String postTrasaction(@RequestBody Transaction transaction) {
		repository.save(transaction);
		return "Added Transaction of type : "+ transaction.getTransactionType() + " for account : " + transaction.getAccountNumber() + " with amount : " + transaction.getAmount();
	}
	
	@GetMapping("/allTransactions")
	public List<Transaction> getalltransactions(){
		return repository.findAll();
	}
	
	@GetMapping("/findTransaction/{id}")
	public Optional<Transaction> getTransactionById(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/deleteTransaction/{id}")
	public String deleteTransaction(@PathVariable int id) {
		repository.deleteById(id);
		return "Transaction deleted with id :" + id;
	}
	
}
