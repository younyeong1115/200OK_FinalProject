package shop.myshop.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@Entity
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
	private Integer deliveryId;
	private String nonUserPayment;
	@Temporal(TemporalType.TIMESTAMP)
	private  Date nonUserRegdate;
	private String nonUserStatus;
	
	@OneToOne(mappedBy = "nonUserCode")
	private List<NonUserOrderDetail> nonuserorderdetail= new ArrayList<NonUserOrderDetail>();
	
	
}
