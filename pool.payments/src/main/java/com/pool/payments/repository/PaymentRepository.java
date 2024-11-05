package com.pool.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.payments.entity.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {

}
