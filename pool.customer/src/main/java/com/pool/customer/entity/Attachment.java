package com.pool.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attachment extends AuditFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name =  "file")
	private String file;
	
	@Column(name =  "file_name")
	private String fileName;
	
	@Column(name =  "original_file_name")
	private String originalFileName;
	
	@Column(name =  "file_type")
	private String fileType;
	
}
