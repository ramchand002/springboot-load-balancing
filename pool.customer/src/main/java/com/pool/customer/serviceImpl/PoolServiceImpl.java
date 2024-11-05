package com.pool.customer.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pool.customer.dto.PoolDto;
import com.pool.customer.dto.UserDto;
import com.pool.customer.entity.Pool;
import com.pool.customer.entity.User;
import com.pool.customer.repository.PoolRepository;
import com.pool.customer.repository.UserRepository;
import com.pool.customer.service.PoolService;

@Service
public class PoolServiceImpl implements PoolService {
	@Autowired
	private PoolRepository poolRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public PoolDto save(PoolDto poolDto) {
		// TODO Auto-generated method stub
		
		Pool pool = new Pool();
		pool.setId(poolDto.getId());
		pool.setActive(true);
		pool.setCreationDate(LocalDateTime.now());
		pool.setDeleted(false);
		pool.setPoolName(poolDto.getPoolName());
		pool.setUpdationDate(LocalDateTime.now());
		pool.setLocation(poolDto.getLocation());
		User usrUser = userRepository.findById(poolDto.getUserId()).orElse(null);
		pool.setUser(usrUser);
	    Pool responsePool = poolRepository.save(pool);
	    return mapPoolDto(responsePool);
	  }
	
	private PoolDto mapPoolDto(Pool pool) {
		PoolDto obj = new PoolDto();
		obj.setId(pool.getId());
		obj.setLocation(pool.getLocation());
		obj.setPoolName(pool.getPoolName());
		if (Objects.nonNull(pool.getUser())) {
			UserDto objUser = new UserDto();
			objUser.setFirstName(pool.getUser().getFirstName());
			objUser.setLastName(pool.getUser().getLastName());
			objUser.setId(pool.getUser().getId());
			obj.setUser(objUser);
		}
		return obj;
	}

	@Override
	public List<PoolDto> getAll() {
		// TODO Auto-generated method stub
		List<Pool> pools = poolRepository.findAll();
		return pools.stream().map(this::mapPoolDto).collect(Collectors.toList());
	}

	@Override
	public PoolDto getById(long id) {
		// TODO Auto-generated method stub
        Pool obj = poolRepository.findById(id).orElse(null);
        return mapPoolDto(obj);
	}
 
}
