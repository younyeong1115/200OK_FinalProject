package shop.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity(name = "Nonuserorderdetail")
public class NonUserOrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonDetailCode;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="productCode")
	private Product productCode;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="nonUserCode")
	private NonUserOrder nonUserCode;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="deliveryId")
	private Delivery deliveryId;
	
	@NonNull
	@Column(nullable = false)
	private Integer nonDetailPrice;
	
	

}
