package com.pool.customer.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AuditFields {
@Column(name =  "creation_date")
private LocalDateTime creationDate;

@Column(name =  "updation_date")
private LocalDateTime updationDate;

@Column(name =  "created_by")
private long createdBy;

@Column(name =  "updated_by")
private long updatedBy;

@Column(name =  "is_active")
private boolean isActive;

@Column(name =  "is_deleted")
private boolean isDeleted;
}
