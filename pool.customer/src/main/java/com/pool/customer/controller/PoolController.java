package com.pool.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.customer.dto.PoolDto;
import com.pool.customer.service.PoolService;

@RestController
@RequestMapping("/api/customer/pool")
public class PoolController {

	@Autowired
	private PoolService poolService;
	
	
	@PostMapping
	public PoolDto save(@RequestBody PoolDto pool) {
		return poolService.save(pool);
	}
	
	@GetMapping
	public List<PoolDto> getAll() {
		return poolService.getAll();
	}
	
	@GetMapping("/{id}")
	public PoolDto getById(@PathVariable Long id) {
		return poolService.getById(id);
	}
}
