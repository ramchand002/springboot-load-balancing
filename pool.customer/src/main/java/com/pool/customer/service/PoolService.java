package com.pool.customer.service;

import java.util.List;

import com.pool.customer.dto.PoolDto;

public interface PoolService {
  PoolDto save(PoolDto pool);
  List<PoolDto> getAll();
  PoolDto getById(long id);
}
