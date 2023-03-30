package shop.myshop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.entity.Delivery;
import shop.myshop.entity.User;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrdersDTO {

	private Integer orderCode;

	
	private User userId;

	
	private Date orderRegdate;

	
	private String orderPayment;

	
	private Delivery deliveryId;

	
	private String orderStatus;
	
	
	private String orderTotalPrice;
	
	
}
