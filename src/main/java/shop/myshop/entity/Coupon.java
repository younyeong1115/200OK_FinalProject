package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer couponCode;
	
	@NonNull
	@Column(nullable = false)
	private String couponName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NonNull
	@Column(nullable = false)
	private  Date couponUsedate;
	
	@NonNull
	@Column(nullable = false)
	private String couponBenefit;
	
	@NonNull
	@Column(nullable = false)
	private String couponPrice;
	
	@NonNull
	@Column(nullable = false)
	private String couponPayment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NonNull
	@Column(nullable = false)
	private Date couponExpdate;
	
	@NonNull
	@Column(nullable = false)
	private String couponUseYN;

	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	
	
	
	
}
