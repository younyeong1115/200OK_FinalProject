package shop.myshop.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.entity.Delivery;
import shop.myshop.entity.User;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NonUserOrderDTO {
	
	private Integer nonUserCode;	
	private String nonUserPwd;
	private String nonUserName;
	private String nonUserMobile;
	private String nonUserEmail;
	private Delivery deliveryId;
	private String nonUserPayment;
	private Timestamp nonUserRegdate;
	private String nonUserStatus;
	
}
