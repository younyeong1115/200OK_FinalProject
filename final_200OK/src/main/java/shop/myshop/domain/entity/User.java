package shop.myshop.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

@Entity
public class User {
	@Id
	private String userId;	
	private String userName;
	private String userPwd;
	private String userMobile;
	private String userPhone;
	private String userAddress;
	private String userEmailWhether;
	private String userSnsWhether;
	private String userEmail;
	@Temporal(TemporalType.TIMESTAMP)
	private  Date userRegdate;
	
}
