package com.vlsystem.picpay.domain.user;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fisrtName;
	
	private String lasttName;
	
	private String document;
	
	@Column(unique = true)
	private String passworld;
	
	@Column(unique = true)
	private String email;
	
	private BigDecimal balance;
	
	//representa um dos valores do (enum)
	@Enumerated(EnumType.STRING)
	private UserType userType;

}
