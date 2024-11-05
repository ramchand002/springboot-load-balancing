package com.pool.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.feedback.dto.feedbackDto;
import com.pool.feedback.service.FeedbackService;

@RequestMapping("api/feedback/feedback")
@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping
	public feedbackDto save(@RequestBody feedbackDto dto) {
		return feedbackService.save(dto);
	}
	
	@GetMapping("/{id}")
	public feedbackDto getById(@PathVariable long id) {
		return feedbackService.getById(id);
	}
}
