package com.pool.bookings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private long id;
	private String firstName;
	private String lastName;
	private String email;	
	private String phoneNumber;  
	private String poolRandomNumber;    
	private String poolId;
}
