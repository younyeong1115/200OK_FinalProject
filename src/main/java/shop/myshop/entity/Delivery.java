package shop.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private String deliveryAdd1;
	
	@NonNull
	@Column(nullable = false)
	private String deliveryAdd2;
	
	@NonNull
	@Column(nullable = true)
	private String deliveryAdd3;
	
	@Column(nullable = true)
	private String deliveryMemo;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
}
