package com.pool.customer.dto;
import java.io.Serializable;

import com.pool.customer.enums.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto  implements Serializable {
	
	private long id;
	
//	@NotBlank(message = "First name cannot be blank")
//    @Size(min = 3, max = 20, message = "First Name must be between 3 and 20 characters")
	private String firstName;
	
	private String lastName;

	@NotBlank(message = "Email cannot be blank")
	private String email;
	
	private String phoneNumber;
//	
//	@NotBlank(message = "Password cannot be blank")
//    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
	private String password;
    
    private boolean emailVerified;
    
	private Gender gender;
	
    private long roleId;
    
    private long attachmentId;
    
    private RoleDto role;            // Include RoleDto
    private AttachmentDto attachment; // Include AttachmentDto

}
