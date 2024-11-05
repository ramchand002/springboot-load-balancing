package com.pool.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pool.customer.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

@Query("Select r from Role r where r.isActive = :is_active and r.isDeleted = :is_deleted")	
 List<Role> findActiveRoles(@Param("is_active") boolean is_active, @Param("is_deleted") boolean is_deleted);
}
