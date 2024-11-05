package com.pool.customer.service;

import com.pool.customer.dto.LoginDto;
import com.pool.customer.dto.LoginResponseDto;
import com.pool.customer.dto.UserDto;

public interface UserService {
	UserDto save(UserDto dto);
	UserDto update(UserDto dto);
	UserDto getUser(long id);
	LoginResponseDto login(LoginDto dto);
}
