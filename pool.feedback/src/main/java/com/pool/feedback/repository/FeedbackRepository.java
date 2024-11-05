package com.pool.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.feedback.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
