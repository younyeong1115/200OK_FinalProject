package shop.myshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.entity.Delivery;
import shop.myshop.entity.NonUserOrder;
import shop.myshop.entity.Product;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NonUserOrderDetailDTO {
	
	private Integer nonDetailCode;
	private Product productCode;
	private NonUserOrder nonUserCode;
	private Delivery deliveryId;
	private Integer nonDetailPrice;
	
}
