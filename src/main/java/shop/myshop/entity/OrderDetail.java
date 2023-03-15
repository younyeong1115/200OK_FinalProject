package shop.myshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity(name = "orderdetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer detailCode;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="productCode")
	private Product productCode;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="orderCode")
	private Orders orderCode;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="deliveryId")
	private Delivery deliveryId;
	private Integer orderDetailSale;
	private Integer orderDetailMileage;
	private Integer orderDetailPrice;
	
	
	
}
