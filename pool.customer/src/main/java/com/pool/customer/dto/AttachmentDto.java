package com.pool.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDto {
	private long id;
	
	private String file;
	
	private String fileName;
	
	private String originalFileName;
	
	private String fileType;
}
