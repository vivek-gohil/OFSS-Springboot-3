package com.ofss.main.service;

import org.springframework.stereotype.Service;

@Service
public class VoteService {
	public String vote(int age) {
		return "Voted";
	}
}
