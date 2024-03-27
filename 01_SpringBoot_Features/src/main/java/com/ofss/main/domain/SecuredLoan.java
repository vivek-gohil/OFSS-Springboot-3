package com.ofss.main.domain;

public final class SecuredLoan implements Loan {

	@Override
	public String processLoan() {
		return "Your secured loan is getting processed!";
	}

}
