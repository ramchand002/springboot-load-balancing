package com.pool.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.customer.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

}
