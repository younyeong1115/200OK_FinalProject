package shop.myshop.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartNo;
	private Integer cartQuantity;
	private Integer cartTotalprice;

	@ManyToOne
	@NonNull
	@JoinColumn(name="productCode")
	private Integer productCode;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private String userId;
	

}
