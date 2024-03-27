package com.ofss.main.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Loan;
import com.ofss.main.domain.SecuredLoan;
import com.ofss.main.domain.UnsecuredLoan;
import com.ofss.main.dto.Address;
import com.ofss.main.dto.Employee;
import com.ofss.main.exception.InvalidAgeException;
import com.ofss.main.service.LoanDetailsService;
import com.ofss.main.service.VoteService;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

@RestController
@RequestMapping("springbootfeaturesapi")
public class SpringBootFeaturesController {

	@Autowired
	private LoanDetailsService loanDetailsService;

	@Autowired
	private VoteService voteService;

	@Autowired
	private ObservationRegistry observationRegistry;

	@GetMapping("greet")
	public String greet() {
		return "Good Afternoon all";
	}

	@GetMapping("employeerecord")
	public ResponseEntity<Employee> printEmployee() {

		var addressLine1 = """
				B-212, Nisarg chs,
				J.B. Road,
				Opposite to  indian cancer chs,
				""";

		var addressLine2 = """
					Parel , Mumbai
				""";

		var employee = new Employee(101, "OFSS", 10000,
				new Address(1, addressLine1, addressLine2, "Parel , Mumbai", 400012));
		System.out.println(employee);
		return ResponseEntity.ok(employee);

	}

	@GetMapping("loan/{loanChoice}")
	public String displayLoanDetails(@PathVariable int loanChoice) {
		Loan loan;
		if (loanChoice == 1) {
			loan = new UnsecuredLoan(15);
		} else {
			loan = new SecuredLoan();
		}

		return loanDetailsService.doLoanProcessing(loan);
	}

	@GetMapping("vote/{age}")
	public ResponseEntity vote(@PathVariable int age) {
		if (age >= 18) {
			// return ResponseEntity.ok(voteService.vote(age));
			return Observation.createNotStarted("vote", observationRegistry)
					.observe(() -> ResponseEntity.ok(voteService.vote(age)));
		} else {
			throw new InvalidAgeException();
		}
	}

}
