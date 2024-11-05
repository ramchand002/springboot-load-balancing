package com.pool.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class feedbackDto {
	private long id;
	
	private String feedback;
	
	private String userId;
}
