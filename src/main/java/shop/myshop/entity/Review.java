package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Column;
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

@Entity(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewNo;
	@ManyToOne
	@NonNull
	@JoinColumn(name="productCode")
	private Product productCode;
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	@ManyToOne
	@NonNull
	@JoinColumn(name="orderCode")
	private Orders orderCode;
	
	@NonNull
	@Column(nullable = false)
	private String reviewContent;
	
	@NonNull
	@Column(nullable = false)
	private String reviewStarScope;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NonNull
	@Column(nullable = false)
	private  Date reviewRegdate;
	
	@Column(nullable = true)
	private String reviewImage1;
	@Column(nullable = true)
	private String reviewImage2;
	@Column(nullable = true)
	private String reviewImage3;
	
	
	
}
