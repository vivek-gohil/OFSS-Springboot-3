package com.ofss.main.domain;

public sealed interface Loan permits SecuredLoan, UnsecuredLoan {
	String processLoan();
}
