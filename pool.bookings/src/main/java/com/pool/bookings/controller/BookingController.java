package com.pool.bookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.bookings.dto.BookingDto;
import com.pool.bookings.service.BookingService;

@RestController
@RequestMapping("/api/booking/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public BookingDto save(@RequestBody BookingDto dto) {
		return bookingService.save(dto);
	}
	
	@GetMapping("/{id}")
	public BookingDto getById(@PathVariable long id) {
		return bookingService.getById(id);
	}
}
