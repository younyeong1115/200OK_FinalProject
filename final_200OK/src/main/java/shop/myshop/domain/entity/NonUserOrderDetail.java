package shop.myshop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString

@Entity
public class NonUserOrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nonDetailCode;
	@OneToMany
	@NonNull
	@JoinColumn(name="productCode")
	private Product productCode;
	@OneToOne
	@NonNull
	@JoinColumn(name="nonUserCode")
	private NonUserOrder nonUserCode;
	@OneToOne
	@NonNull
	@JoinColumn(name="deliveryId")
	private Delivery deliveryId;
	private Integer nonDetailPrice;
	
	

}
