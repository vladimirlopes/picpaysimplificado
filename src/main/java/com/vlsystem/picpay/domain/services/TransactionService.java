package com.vlsystem.picpay.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.picpay.domain.dto.TransactionDto;
import com.vlsystem.picpay.domain.user.User;
import com.vlsystem.picpay.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionRepository repository;
	
	public void createTransaction(TransactionDto transaction) throws Exception {
		User sender = this.userService.findUserById(transaction.senderId());
		User reciver = this.userService.findUserById(transaction.reciverId());
		userService.validarTransacao(sender, transaction.value());
		
	}

}
