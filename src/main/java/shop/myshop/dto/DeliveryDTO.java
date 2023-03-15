package shop.myshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeliveryDTO {
	
	private Integer deliveryId;	
	private String deliveryName;
	private Integer deliveryZipcode;	
	private String deliveryMobile;
	private String deliveryAddress;
	private String deliveryMemo;
	
}
