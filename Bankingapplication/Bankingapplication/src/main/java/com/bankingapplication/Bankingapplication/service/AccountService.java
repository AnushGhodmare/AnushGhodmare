package com.bankingapplication.Bankingapplication.service;

import java.util.List;


import com.bankingapplication.Bankingapplication.entity.Accounts;


public interface AccountService {
	public Accounts createAccount(Accounts account);
	public Accounts getaccountdetails(Long accountnumber);
	public Accounts withdraw(Long accountnumber, Double amount);
	public Accounts deposit(Long accountnumber,Double amount);
	public List<Accounts> getallaccountdetails();
	public void close(Long accountnumber);
	
	
}
