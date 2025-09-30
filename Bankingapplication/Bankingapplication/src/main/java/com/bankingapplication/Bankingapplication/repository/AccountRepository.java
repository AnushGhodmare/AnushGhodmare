package com.bankingapplication.Bankingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankingapplication.Bankingapplication.entity.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Long> {


	
}
