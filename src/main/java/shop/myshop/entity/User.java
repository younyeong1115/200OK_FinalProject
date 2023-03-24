package shop.myshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.dto.Role;
@DynamicInsert   //(insert 시 null 인필드 제외)
@DynamicUpdate //(update 시 null 인필드 제외)
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
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
	
	
	@NonNull
	@Column(nullable = false)
	private String userAddr1;
	
	@NonNull
	@Column(nullable = false)
	private String userAddr2;
	
	@Column(nullable = true)
	private String userAddr3;
	
	@Column(nullable = true )
	private String userEmailwhether;
	

	@Column(nullable = true)
	private String userSnswhether;
	
	@NonNull
	@Column(nullable = false)
	private String userEmail;
	
    	
	
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role userRole;
	
	@NonNull
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false )
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
