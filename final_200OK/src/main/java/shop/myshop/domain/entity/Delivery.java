package shop.myshop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity(name = "delivery")
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryId;	
	private String deliveryName;
	private Integer deliveryZipcode;	
	private String deliveryMobile;
	private String deliveryAddress;
	private String deliveryMemo;
	
	
	

}
