package shop.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Entity(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartNo;
	
	@NonNull
	@Column(nullable = false)
	private Integer cartQuantity;
	
	@NonNull
	@Column(nullable = false)
	private Integer cartTotalprice;

	@ManyToOne
	@NonNull
	@Column(nullable = false)
	@JoinColumn(name="productCode")
	private Product productCode;
	
	@ManyToOne
	@NonNull
	@Column(nullable = false)
	@JoinColumn(name="userId")
	private User userId;
	

}
