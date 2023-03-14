package shop.myshop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

@Entity
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer detailCode;	
	private Integer productCode;
	private Integer orderCode;
	private Integer deliveryId;
	private Integer orderDetailSale;
	private Integer orderDetailMileage;
	private Integer orderDetailPrice;
	
	
	
}
