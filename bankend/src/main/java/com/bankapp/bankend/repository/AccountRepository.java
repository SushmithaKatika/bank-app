package com.bankapp.bankend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.bankend.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
