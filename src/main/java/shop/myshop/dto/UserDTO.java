package shop.myshop.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.entity.Orders;
import shop.myshop.entity.Product;
import shop.myshop.entity.User;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
	
	private String userId;	
	private String userName;
	private String userPwd;
	private String userMobile;
	private String userPhone;
	private String userAddress;
	private String userEmailWhether;
	private String userSnsWhether;
	private String userEmail;
	private Role userRole;
	private Timestamp userRegdate;
	
	public UserDTO(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	
	
	
}
