package shop.myshop.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
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
	private String couponName;
	@Temporal(TemporalType.TIMESTAMP)
	private  Date couponUsedate;
	private String couponBenefit;
	private String couponPrice;
	private String couponPayment;
	@Temporal(TemporalType.TIMESTAMP)
	private Date couponExpdate;
	private String couponUseYN;

	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private String userId;
	
	
	
	
	
}
