package com.bankapp.bankend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.bankend.dto.AccountDto;
import com.bankapp.bankend.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountService;
	
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	//add account rest api
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		
		System.out.println(accountDto);
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
}
