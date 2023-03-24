package shop.myshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderCode;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NonNull
	@Column(nullable = false)
	private  Date orderRegdate;
	
	@NonNull
	@Column(nullable = false)
	private Integer orderDeliveryCharge;
	
	@NonNull
	@Column(nullable = false)
	private String orderPayment;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="deliveryId")
	private Delivery deliveryId;
	
	@NonNull
	@Column(nullable = false)
	private String orderStatus;
	
	@OneToMany(mappedBy = "orderCode")
	private List<Review> review = new ArrayList<Review>();
	
	
	
	
	
}
