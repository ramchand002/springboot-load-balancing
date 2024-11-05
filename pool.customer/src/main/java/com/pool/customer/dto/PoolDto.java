package com.pool.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PoolDto {
	private long id;
	private long userId;
	private String poolName;
	private String location;
	private UserDto user;
}
