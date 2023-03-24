package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Column;
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

@Entity(name = "Nonuserorder")
public class NonUserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonUserCode;	
	
	@NonNull
	@Column(nullable = false)
	private String nonUserPwd;
	
	@NonNull
	@Column(nullable = false)
	private String nonUserName;
	
	@NonNull
	@Column(nullable = false)
	private String nonUserMobile;
	
	@Column(nullable = true)
	private String nonUserEmail;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="nonuserId")
	private NonUserDelivery nonuserId;
	
	@NonNull
	@Column(nullable = false)
	private String nonUserPayment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NonNull
	@Column(nullable = false)
	private  Date nonUserRegdate;
	
	@NonNull
	@Column(nullable = false)
	private String nonUserStatus;
	
	
}
