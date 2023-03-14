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
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderCode;	
	private String userId;
	@Temporal(TemporalType.TIMESTAMP)
	private  Date orderRegdate;
	private Integer orderDeliveryCharge;
	private String orderPayment;
	private Integer deliveryId;
	private String orderStatus;
	
	
	
}
