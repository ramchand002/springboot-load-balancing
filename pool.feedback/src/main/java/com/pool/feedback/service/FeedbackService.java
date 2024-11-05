package com.pool.feedback.service;

import com.pool.feedback.dto.feedbackDto;

public interface FeedbackService {

	feedbackDto save(feedbackDto dto);
	feedbackDto getById(long id);
}
