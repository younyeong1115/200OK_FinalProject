package shop.myshop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer detailCode;
	
	@OneToMany
	@NonNull
	@JoinColumn(name="productCode")
	private Integer productCode;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="orderCode")
	private Integer orderCode;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="deliveryId")
	private Integer deliveryId;
	private Integer orderDetailSale;
	private Integer orderDetailMileage;
	private Integer orderDetailPrice;
	
	
	
}
