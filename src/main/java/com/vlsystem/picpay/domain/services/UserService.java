package com.vlsystem.picpay.domain.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.picpay.domain.user.User;
import com.vlsystem.picpay.domain.user.UserType;
import com.vlsystem.picpay.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void validarTransacao(User sender, BigDecimal amount) throws Exception {
		// verificar se o usuario está autorizado a realizar a transação
		if (sender.getUserType() == UserType.MERCHANT) {
			throw new Exception("Usuario do tipo Logista não esta autorizado a realizar transação");

		}
		// verificar se o saldo é suficiente para realizar a transação
		if (sender.getBalance().compareTo(amount) < 0) {
			throw new Exception("saldo insuficiente!");
		}
	}
	// lancar uma excessão se o usuario não for encontrado
	public User findUserById(Long id) throws Exception {
		return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario não Encontrado"));
	}
	public void salvarUsuario(User user) {
		this.userRepository.save(user);
		
	}

}
