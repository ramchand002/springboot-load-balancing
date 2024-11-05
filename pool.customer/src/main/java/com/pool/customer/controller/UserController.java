package com.pool.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.customer.dto.UserDto;
import com.pool.customer.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/customer/user")
public class UserController {
	
	@Autowired
	private UserService _userService;

	@PostMapping
	private UserDto save(@Valid @RequestBody UserDto dto) {
		return _userService.save(dto);
	}
	
	@PutMapping
	private UserDto update(@RequestBody UserDto dto) {
		return _userService.update(dto);
	}
	
	@GetMapping("/{id}")
	private UserDto get(@PathVariable long id) {
		return _userService.getUser(id);
	}
	
}
