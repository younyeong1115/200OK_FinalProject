package shop.myshop.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

@Entity
public class NonUserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonUserCode;	
	private String nonUserPwd;
	private String nonUserName;
	private String nonUserMobile;
	private String nonUserEmail;
	private Integer deliveryId;
	private String nonUserPayment;
	@Temporal(TemporalType.TIMESTAMP)
	private  Date nonUserRegdate;
	private String nonUserStatus;
	
	
	
}
