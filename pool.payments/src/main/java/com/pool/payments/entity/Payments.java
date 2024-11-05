package com.pool.payments.entity;

import com.pool.payments.enums.Payment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_id")
	private long userId;
	

	@Column(name = "pool_id")
	private long poolId;
	
	@Column(name = "ammount_paid")
	private int ammountPaid;
	
	@Column(name = "currency_type")
	private String currencyType;
	
	@Column(name = "is_success")
	private Boolean isSuccess;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_mode")
	private Payment paymentMode;
	
	
}
