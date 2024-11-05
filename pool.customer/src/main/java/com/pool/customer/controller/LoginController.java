package com.pool.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.customer.dto.LoginDto;
import com.pool.customer.dto.LoginResponseDto;
import com.pool.customer.service.UserService;

@RestController
@RequestMapping("api/customer/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public LoginResponseDto login(@RequestBody LoginDto dto) {
		return userService.login(dto);
	}

}
