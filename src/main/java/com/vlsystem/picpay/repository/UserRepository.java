package com.vlsystem.picpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlsystem.picpay.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//encontra o usuario dentro da tabela na coluna documento
	Optional<User>findUserByDocument(String document);
	
	//encontra o usuario por id
	Optional<User>findUserById(Long id);

}
