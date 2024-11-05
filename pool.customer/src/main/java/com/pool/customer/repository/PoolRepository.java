package com.pool.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.customer.entity.Pool;

@Repository
public interface PoolRepository extends JpaRepository<Pool, Long>{

}
