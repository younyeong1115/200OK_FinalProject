package shop.myshop.entity;

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
@Entity
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer likeNo;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="productCode")
	private Product productCode;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
}
