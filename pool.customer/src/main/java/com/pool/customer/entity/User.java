package com.pool.customer.entity;

import java.util.Set;

import com.pool.customer.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AuditFields {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
//	@NotBlank(message = "First name cannot be blank")
//    @Size(min = 3, max = 20, message = "First Name must be between 3 and 20 characters")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

    @Column(name = "email")
    @NotBlank(message = "Email cannot be blank")
	private String email;
	
    @Column(name = "phone_number")
	private String phoneNumber;
	
    @Column(name = "password")
//    @NotBlank(message = "First name cannot be blank")
//    @Size(min = 3, max = 20, message = "First Name must be between 3 and 20 characters")
	private String password;
    
    @Column(name = "email_verified")
    private boolean emailVerified;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
    
    @ManyToOne
    @JoinColumn(name = "attachment_id", referencedColumnName = "id")
    private Attachment attachment;
	
    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Set<Pool> pools;

}
