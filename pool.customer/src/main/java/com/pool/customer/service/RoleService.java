package com.pool.customer.service;

import java.util.List;

import com.pool.customer.dto.RoleDto;

public interface RoleService {
  RoleDto save(RoleDto role);
  List<RoleDto> getRoles();
}
