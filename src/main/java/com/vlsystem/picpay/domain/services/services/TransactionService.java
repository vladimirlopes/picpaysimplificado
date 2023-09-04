package com.vlsystem.picpay.domain.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vlsystem.picpay.domain.dto.TransactionDto;
import com.vlsystem.picpay.domain.transaction.Transaction;
import com.vlsystem.picpay.domain.user.User;
import com.vlsystem.picpay.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	public void createTransaction(TransactionDto transaction) throws Exception {
		User sender = this.userService.findUserById(transaction.senderId());
		User reciver = this.userService.findUserById(transaction.reciverId());
		userService.validarTransacao(sender, transaction.value());
		
		boolean isAutorized = this.authorizeTransaction(sender, transaction.value());
		if(!isAutorized) {
			throw new Exception("tranzação não autorizada");
			
		}
			Transaction newTransaction = new Transaction();
			newTransaction.setSander(sender);
			newTransaction.setReciver(reciver);
			newTransaction.setTimestamp(LocalDateTime.now());
		}

	public boolean authorizeTransaction(User sender, BigDecimal value) {
		ResponseEntity<Map> autorizationResponse = restTemplate.getForEntity(
				" https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6 ", Map.class);
		if (autorizationResponse.getStatusCode() == HttpStatus.OK) {
			String message = (String) autorizationResponse.getBody().get("message");
			return "autorizado".equalsIgnoreCase(message);

		} else
			return false;

	}

}
