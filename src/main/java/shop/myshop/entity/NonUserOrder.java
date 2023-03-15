package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity(name = "nonuserorder")
public class NonUserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonUserCode;	
	private String nonUserPwd;
	private String nonUserName;
	private String nonUserMobile;
	private String nonUserEmail;
	@OneToOne
	@NonNull
	@JoinColumn(name="deliveryId")
	private Delivery deliveryId;
	private String nonUserPayment;
	@Temporal(TemporalType.TIMESTAMP)
	private  Date nonUserRegdate;
	private String nonUserStatus;
	
	
}
