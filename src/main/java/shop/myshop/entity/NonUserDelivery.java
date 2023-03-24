package shop.myshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Entity(name = "Nonuserdelivery")
public class NonUserDelivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonuserId;	
	
	@NonNull
	@Column(nullable = false)
	private String nonuserName;
	
	@NonNull
	@Column(nullable = false)
	private Integer nonuserZipcode;	
	
	@NonNull
	@Column(nullable = false)
	private String nonuserMobile;
	
	@NonNull
	@Column(nullable = false)
	private String nonuserAdd1;
	
	@NonNull
	@Column(nullable = false)
	private String nonuserAdd2;
	
	@NonNull
	@Column(nullable = true)
	private String nonuserAdd3;
	
	@Column(nullable = true)
	private String nonuserMemo;
	
	@OneToMany(mappedBy = "nonuserId")
	private List<NonUserOrder> nonUserOrder = new ArrayList<NonUserOrder>();
	
	@OneToMany(mappedBy = "nonuserId")
	private List<NonUserOrderDetail> nonUserOrderDetail = new ArrayList<NonUserOrderDetail>();

}
