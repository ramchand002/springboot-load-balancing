package com.pool.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pool.customer.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("Select u from User u where u.email = :userName and u.isDeleted = :is_deleted")	
	User getUserByEmail(@Param("userName") String userName, @Param("is_deleted") boolean is_deleted);
}
