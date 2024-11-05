package com.pool.feedback.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pool.feedback.dto.feedbackDto;
import com.pool.feedback.entity.Feedback;
import com.pool.feedback.repository.FeedbackRepository;
import com.pool.feedback.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	@Override
	public feedbackDto save(feedbackDto dto) {
		// TODO Auto-generated method stub
		Feedback obj = new Feedback();
		obj.setId(dto.getId());
		obj.setCreatedDate(LocalDateTime.now());
		obj.setFeedback(dto.getFeedback());
		obj.setUserId(dto.getUserId());	
		Feedback response = feedbackRepository.save(obj);
		return mapFeedbacjDto(response);
	}
	
	private feedbackDto mapFeedbacjDto(Feedback feedback) {
		feedbackDto obj = new feedbackDto();
		obj.setFeedback(feedback.getFeedback());
		obj.setId(feedback.getId());
		obj.setUserId(feedback.getUserId());
		return obj;
	}
	
	public feedbackDto getById(long id) {
		Feedback res = feedbackRepository.findById(id).orElse(null);
		return mapFeedbacjDto(res);
	}

}
