package com.ofss.main.service;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Loan;
import com.ofss.main.domain.SecuredLoan;
import com.ofss.main.domain.UnsecuredLoan;

@Service
public class LoanDetailsService {

	public String doLoanProcessing(Loan loan) {
//		if (loan instanceof SecuredLoan) {
//			var securedLoan = loan;
//			return securedLoan.processLoan();
//		}
//		if (loan instanceof UnsecuredLoan) {
//			var unsecuredLoan = loan;
//			return unsecuredLoan.processLoan();
//		}

		// Pattern matching 17
//		if (loan instanceof SecuredLoan securedLoan) {
//			return securedLoan.processLoan();
//		}
//		if (loan instanceof UnsecuredLoan unsecuredLoan) {
//			return unsecuredLoan.processLoan();
//		}
//		return null;

		// Using Switch Expression
//		var message = switch (loan) {
//		case UnsecuredLoan unsecuredLoan -> unsecuredLoan.processLoan();
//		case SecuredLoan securedLoan -> securedLoan.processLoan();
//		};
//
//		return message;

		return switch (loan) {
		case UnsecuredLoan unsecuredLoan -> unsecuredLoan.processLoan();
		case SecuredLoan securedLoan -> securedLoan.processLoan();
		};
		
	}
}
