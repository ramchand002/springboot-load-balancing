package com.pool.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.customer.dto.RoleDto;
import com.pool.customer.service.RoleService;

@RestController
@RequestMapping("/api/customer/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public RoleDto saveRole(@RequestBody RoleDto dto) {
		return roleService.save(dto);
	}
	
	@GetMapping
	public List<RoleDto> getRoles() {
		return roleService.getRoles();
	}
}
