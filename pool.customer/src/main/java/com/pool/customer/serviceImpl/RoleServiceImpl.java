package com.pool.customer.serviceImpl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pool.customer.dto.RoleDto;
import com.pool.customer.entity.Role;
import com.pool.customer.repository.RoleRepository;
import com.pool.customer.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public RoleDto save(RoleDto dto) {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setName(dto.getName());
		role.setActive(true);
		role.setDeleted(false);
		role.setCreationDate(LocalDateTime.now());
		role.setUpdationDate(LocalDateTime.now());
		Role responseRole = roleRepository.save(role);
		dto.setId(responseRole.getId());
		return dto;
	}


	@Override
	public List<RoleDto> getRoles() {
		// TODO Auto-generated method stub
		List<Role> roles = roleRepository.findActiveRoles(true, false);
		if (roles == null || roles.isEmpty()) {
			return Collections.emptyList();
		}
		return roles.stream().filter(role -> role!= null)
		             .map(role-> mapToRoleDto(role))
		             .collect(Collectors.toList());
		
	}
	
	public RoleDto mapToRoleDto(Role role) { 
		return new RoleDto(role.getId(), role.getName());
	}

}
