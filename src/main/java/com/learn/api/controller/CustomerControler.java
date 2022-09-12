package com.learn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.constants.UrlDefine;
import com.learn.api.dto.ApiResponse;
import com.learn.api.dto.CustomerDto;
import com.learn.api.services.CustomerService;

@RestController
public class CustomerControler {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(UrlDefine.CUSTOMER_INFO)
	public ApiResponse<List<CustomerDto>> getAll() {
		List<CustomerDto> customerDtos = null;
		try {
			customerDtos = customerService.getAll();
		} catch (Exception e) {
			return new ApiResponse<List<CustomerDto>>(customerDtos, HttpStatus.EXPECTATION_FAILED);
		}
		return new ApiResponse<List<CustomerDto>>(customerDtos, HttpStatus.OK);
	}
	

}
