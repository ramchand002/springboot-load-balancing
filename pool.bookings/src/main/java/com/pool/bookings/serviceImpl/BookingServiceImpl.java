package com.pool.bookings.serviceImpl;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pool.bookings.dto.BookingDto;
import com.pool.bookings.entity.Bookings;
import com.pool.bookings.repository.BookingRepository;
import com.pool.bookings.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public BookingDto save(BookingDto dto) {
		// TODO Auto-generated method stub
		Bookings obj = new Bookings();
		obj.setEmail(dto.getEmail());
		obj.setFirstName(dto.getFirstName());
		obj.setId(dto.getId());
		obj.setLastName(dto.getLastName());
		obj.setPhoneNumber(dto.getPhoneNumber());
		obj.setPoolId(dto.getPoolId());
		obj.setPoolRandomNumber(getRandomNumberAsString(12345, 99999));
		Bookings res = bookingRepository.save(obj);
		return mapBookingDto(res);
		
	}
	
	 public String getRandomNumberAsString(int min, int max) {
	        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
	        return String.valueOf(randomNumber);
	    }
	 
	 private BookingDto mapBookingDto(Bookings dto) {
		 BookingDto obj = new BookingDto();
		 obj.setEmail(dto.getEmail());
	     obj.setFirstName(dto.getFirstName());
	     obj.setId(dto.getId());
	     obj.setLastName(dto.getLastName());
	     obj.setPhoneNumber(dto.getPhoneNumber());
	     obj.setPoolId(dto.getPoolId());
	     obj.setPoolRandomNumber(dto.getPoolRandomNumber());
	     return obj;
	 }

	@Override
	public BookingDto getById(long id) {
		// TODO Auto-generated method stub
		Bookings bookings = bookingRepository.findById(id).orElse(null);
		return mapBookingDto(bookings);
	}

}
