package shop.myshop.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewNo;
	private Integer productCode;
	private String userId;
	private Integer orderCode;
	private String reviewContent;
	private String reviewStarScope;
	@Temporal(TemporalType.TIMESTAMP)
	private  Date reviewRegdate;
	private String reviewImage1;
	private String reviewImage2;
	private String reviewImage3;
	
	
	
}
