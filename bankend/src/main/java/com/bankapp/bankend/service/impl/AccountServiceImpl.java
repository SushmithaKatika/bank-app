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

}
