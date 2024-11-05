package com.pool.bookings.service;

import com.pool.bookings.dto.BookingDto;

public interface BookingService {
	BookingDto save(BookingDto dto);
	BookingDto getById(long id);
}
