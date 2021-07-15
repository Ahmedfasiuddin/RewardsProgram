package com.java.assignment.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	private int customerId;
	@ApiModelProperty(required = true)
	private LocalDateTime transactionDate;
	@ApiModelProperty(required = true)
	private Integer amountSpent;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", transactionDate=").append(transactionDate)
				.append(", amountSpent=").append(amountSpent).append("]");
		return builder.toString();
	}
	
	
	
	
}
