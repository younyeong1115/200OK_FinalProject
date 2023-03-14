package shop.myshop.domain.entity;

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
	private Integer productCode;
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private String userId;
}
