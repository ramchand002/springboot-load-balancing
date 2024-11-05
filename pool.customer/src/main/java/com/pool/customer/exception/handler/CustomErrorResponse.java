package com.pool.customer.exception.handler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse {
	private String timestamp;
    private String path;
    private int status;
    private String error;
    private String requestId;
    
    
    // Constructor with all fields
    public CustomErrorResponse(int status, String error, String path, String requestId) {
        this.timestamp = LocalDateTime.now().toString();
        this.status = status;
        this.error = error;
        this.path = path;
        this.requestId = requestId;
    }
}
