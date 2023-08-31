package com.vlsystem.picpay.domain.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.vlsystem.picpay.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal balance;
	@ManyToOne
	@JoinColumn(name="sander_id")
	private User sander;
	@ManyToOne
	@JoinColumn(name="reciver_id")
	private User reciver;
	
	private LocalDateTime timestamp;

}
