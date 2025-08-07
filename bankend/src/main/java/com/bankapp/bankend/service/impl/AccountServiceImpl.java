package com.bankapp.bankend.service.impl;

import org.springframework.stereotype.Service;

import com.bankapp.bankend.dto.AccountDto;
import com.bankapp.bankend.entity.Account;
import com.bankapp.bankend.mapper.AccountMapper;
import com.bankapp.bankend.repository.AccountRepository;
import com.bankapp.bankend.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
		
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto getAccountById(Long id) {
		
	Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesnt exist"));
		
		return AccountMapper.mapToAccountDto(account);
	}



	@Override
	public AccountDto deposit(Long id, double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesnt exist"));
		
		double totalBalance = account.getBalance()+amount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesnt exist"));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient balance");
		}
		
		double totalBalance = account.getBalance()-amount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

}
