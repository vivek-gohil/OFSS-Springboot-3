package com.ofss.main.domain;

public record UnsecuredLoan(double intrest) implements Loan {

	@Override
	public String processLoan() {
		return "Your unsecured loan is getting processed with intrest rate of " + intrest + "%";
	}

}
