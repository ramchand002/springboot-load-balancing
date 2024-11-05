package com.pool.bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.bookings.entity.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long> {

}
