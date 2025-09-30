package com.bankingapplication.Bankingapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapplication.Bankingapplication.entity.Accounts;
import com.bankingapplication.Bankingapplication.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {
	
	@Autowired
	AccountRepository repo;

	@Override
	public Accounts createAccount(Accounts account) {
		Accounts account_saved = repo.save(account);
		return account_saved;
	}

	@Override
	public Accounts getaccountdetails(Long accountnumber) {
		Optional <Accounts> account = repo.findById(accountnumber);
		if(account.isEmpty()) {
			throw new RuntimeException("account is not present");
		}
		Accounts account_found = account.get();
		return account_found;
	}

	@Override
	public Accounts withdraw(Long accountnumber, Double amount) {
		Optional<Accounts> account =repo.findById(accountnumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account not found");
		}
		Accounts accountPresent = account.get();
		double accountbalance = accountPresent.getBalance()-amount;
		accountPresent.setBalance(accountbalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Accounts deposit(Long accountnumber, Double amount) {
		Optional<Accounts> account =repo.findById(accountnumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account not found");
		}
		Accounts accountPresent = account.get();
		double totalbalance = accountPresent.getBalance()+amount;
		accountPresent.setBalance(totalbalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public List<Accounts> getallaccountdetails() {
		List<Accounts> allaccounts = repo.findAll();
		return allaccounts;
	}

	@Override
	public void close(Long accountnumber) {
		getaccountdetails(accountnumber);
		repo.deleteById(accountnumber);
		
		
	}
	
}
