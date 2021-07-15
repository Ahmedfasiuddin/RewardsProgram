package com.java.assignment.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.assignment.bean.Transaction;
import com.java.assignment.serviceimpl.transactionServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(tags = "RewardPoint APIs")
@RestController
@RequestMapping(value = "/")
public class TransactionController {
	
	@Autowired
	private transactionServiceImpl challengeServiceImpl;

	
	@PostMapping(value="/transactionList")
	@ApiOperation(value = "Create Challenge ", notes = "Create Challenge")
	 public ResponseEntity<Map<Integer, Map<String, Integer>>> createChallenges(@RequestBody(required = false) List<Transaction> transactions) {
		Map<Integer, Map<String, Integer>> msg = challengeServiceImpl.getRewardPoints(transactions);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

}
