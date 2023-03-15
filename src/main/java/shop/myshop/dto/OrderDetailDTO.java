package shop.myshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.entity.Delivery;
import shop.myshop.entity.Orders;
import shop.myshop.entity.Product;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailDTO {
	
	private Integer detailCode;
	private Product productCode;
	private Orders orderCode;
	private Delivery deliveryId;
	private Integer orderDetailSale;
	private Integer orderDetailMileage;
	private Integer orderDetailPrice;
	
	
}
