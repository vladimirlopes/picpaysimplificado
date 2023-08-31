package com.vlsystem.picpay.domain.dto;

import java.math.BigDecimal;

public record TransactionDto(BigDecimal value, Long senderId, Long reciverId) {
	

}
