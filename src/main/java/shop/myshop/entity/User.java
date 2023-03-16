package shop.myshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity(name ="user")
public class User {
	@Id
	private String userId;
	
	@NonNull
	@Column(nullable = false)
	private String userName;
	
	@NonNull
	@Column(nullable = false)
	private String userPwd;
	
	@NonNull
	@Column(nullable = false)
	private String userMobile;
	
	@Column(nullable = true)
	private String userPhone;
	
	@Column(nullable = true)
	private String userAddress;
	
	@NonNull
	@Column(nullable = false)
	private String userEmailWhether;
	
	@NonNull
	@Column(nullable = false)
	private String userSnsWhether;
	
	@NonNull
	@Column(nullable = false)
	private String userEmail;
	

	@Column(nullable = true)
	private String Role;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NonNull
	@Column(nullable = false)
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
	
	@OneToMany(mappedBy = "userId")
	private List<Answer> answer= new ArrayList<Answer>();
	
	@OneToMany(mappedBy = "userId")
	private List<Notice> notice= new ArrayList<Notice>();
	
	@OneToMany(mappedBy = "userId")
	private List<ProductAnswer> productanswer= new ArrayList<ProductAnswer>();
}
