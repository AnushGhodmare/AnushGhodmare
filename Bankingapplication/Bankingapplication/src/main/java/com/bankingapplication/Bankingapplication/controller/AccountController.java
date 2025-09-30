package com.bankingapplication.Bankingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapplication.Bankingapplication.entity.Accounts;
import com.bankingapplication.Bankingapplication.service.AccountService;



@RestController
@RequestMapping("/account")
public class AccountController{
	@Autowired
	AccountService service;
	
	//create the account
	@PostMapping("/create")
	public Accounts createAccount(@RequestBody Accounts account) {
		Accounts createAccount = service.createAccount(account);
		return createAccount;
	}
	
	@GetMapping("/{accountNumber}")
	public Accounts getaccountdetails(@PathVariable Long accountNumber) {
		Accounts account = service.getaccountdetails(accountNumber);
		return account;
	}
	
	@GetMapping("/getallaccounts")
	public List<Accounts> getAllAccountDetails(){
		List<Accounts> allAccountDetails = service.getallaccountdetails();
		return allAccountDetails;
	}
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Accounts depositAccount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Accounts account = service.deposit(accountNumber, amount);
		return account;
	}
		
	@PutMapping("/withdraw/{accountNumber}/{amount}") 
	public Accounts withdrawaccount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Accounts account = service.withdraw(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public BodyBuilder deleteAccount(@PathVariable Long accountNumber) {
		service.close(accountNumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT);
	}
	
	}


