package shop.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Entity(name = "Orderdetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer detailCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
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
	
	@Column(nullable = true)
	private Integer orderDetailSale;
	
	@Column(nullable = true)
	private Integer orderDetailMileage;
	
	@NonNull
	@Column(nullable = false)
	private Integer orderDetailPrice;
	
	@Override
	public String toString() {
		return "OrderDetail [detailCode=" + detailCode + ", productCode=" + productCode.getProductCode() + ", orderCode=" + orderCode.getOrderCode()
				+ ", deliveryId=" + deliveryId + ", orderDetailSale=" + orderDetailSale + ", orderDetailMileage="
				+ orderDetailMileage + ", orderDetailPrice=" + orderDetailPrice + "]";
	}
	
	
	
}
