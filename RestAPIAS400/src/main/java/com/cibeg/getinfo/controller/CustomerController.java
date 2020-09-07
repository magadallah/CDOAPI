package com.cibeg.getinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibeg.getinfo.repository.CustomerRepository;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping
	public String check() {
		return "Service is working";
	}

	@PostMapping(path = "/getcustnum")
	public List<String[]> getAllCustNum(String cnum) {
		return customerRepository.getAllCustNum(cnum);

	}

	@PostMapping(path = "/getcustact")
	public List<String[]> getCustAct(String cnum) {
		return customerRepository.getCustAct(cnum);
	}

	@PostMapping(path = "/getactdetails")
	public List<String[]> getActDetails(String actNum) {
		return customerRepository.getActDetails(actNum);
	}

}
