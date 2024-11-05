package com.pool.bookings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bookings  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")	
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

    @Column(name = "email")
	private String email;
	
    @Column(name = "phone_number")
	private String phoneNumber;
    
    @Column(name = "pool_random_number")	
	private String poolRandomNumber;
    
    @Column(name = "pool_id")	
	private String poolId;
//    @ManyToOne
//    @JoinColumn(name = "pool_id", referencedColumnName = "id")
//    private Pool pool;
    
}
