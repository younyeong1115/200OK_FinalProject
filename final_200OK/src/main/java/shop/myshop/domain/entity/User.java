package shop.myshop.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "userId")
	private List<Cart> Cart = new ArrayList<Cart>();
	
	@OneToMany(mappedBy = "userId")
	private List<Coupon> coupon = new ArrayList<Coupon>();

	@OneToMany(mappedBy = "userId")
	private List<Orders> orders = new ArrayList<Orders>();
	
	@OneToMany(mappedBy = "userId")
	private List<Question> question = new ArrayList<Question>();
	
	@OneToMany(mappedBy = "userId")
	private List<ProductQuestion> productquestion = new ArrayList<ProductQuestion>();
	
	@OneToMany(mappedBy = "userId")
	private List<Mileage> mileage = new ArrayList<Mileage>();
	
	@OneToMany(mappedBy = "userId")
	private List<Review> review = new ArrayList<Review>();
}
