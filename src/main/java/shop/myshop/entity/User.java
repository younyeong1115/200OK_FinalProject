package shop.myshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.dto.Role;

@NoArgsConstructor
@ToString
@Getter
@Setter
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
	
	@Column(nullable = false )
	private String userEmailwhether;
	
	@NonNull
	@Column(nullable = false)
	private String userSnswhether;
	
	@NonNull
	@Column(nullable = false)
	private String userEmail;
	
    	//테스트 true로바꿈
	//@NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role userRole;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
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
