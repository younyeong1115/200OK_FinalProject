package shop.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryId;	
	
	@NonNull
	@Column(nullable = false)
	private String deliveryName;
	
	@NonNull
	@Column(nullable = false)
	private Integer deliveryZipcode;	
	
	@NonNull
	@Column(nullable = false)
	private String deliveryMobile;
	
	@NonNull
	@Column(nullable = false)
	private String deliveryAddress;
	
	@Column(nullable = true)
	private String deliveryMemo;
	
	
	

}
