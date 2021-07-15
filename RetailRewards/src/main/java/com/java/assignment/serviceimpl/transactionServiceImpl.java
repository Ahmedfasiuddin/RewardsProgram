package com.java.assignment.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.assignment.bean.Transaction;

@Service
public class transactionServiceImpl{
	
	public Map<Integer, Map<String, Integer>> getRewardPoints(List<Transaction> transactionList) {
		Map<String, Integer> monthSpent = new HashMap<>();
		Map<Integer,Map<String, Integer>> customerRewards = new HashMap<>();
		
		for(Transaction transaction : transactionList) {
			String month = transaction.getTransactionDate().getMonth().name();
			int rewards = 0;
			if(transaction.getAmountSpent() < 50) {
				rewards = 0;
			} else if(transaction.getAmountSpent() <=100 && transaction.getAmountSpent() > 50) {
				rewards = 2*(transaction.getAmountSpent() - 50);
			} else if(transaction.getAmountSpent() > 100) {
				int temp1 = transaction.getAmountSpent()/50;
				int temp2 = (2* (transaction.getAmountSpent()-100));
				rewards = ((temp1-1)*50) + temp2;
			}
			if(customerRewards.containsKey(transaction.getCustomerId())) {
				monthSpent = customerRewards.get(transaction.getCustomerId());
			} else {
				monthSpent = new HashMap<>();
				customerRewards.put(transaction.getCustomerId(), monthSpent);
			}

			if(monthSpent.containsKey(month)){
				int total = monthSpent.get(month) + rewards;
				monthSpent.put(month, total);
			} else {
				monthSpent.put(month, rewards);
			}
		}
		return customerRewards;
	}
}
