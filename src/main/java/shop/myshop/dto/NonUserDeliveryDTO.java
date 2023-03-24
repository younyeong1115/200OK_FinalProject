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
public class NonUserDeliveryDTO {
	

	private Integer nonuserId;	
	private String nonuserName;
	private Integer nonuserZipcode;	
	private String nonuserMobile;
	private String nonuserAdd1;
	private String nonuserAdd2;
	private String nonuserAdd3;
	private String nonuserMemo;
	
}
