package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Entity(name = "Productquestion")
public class ProductQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productquestionNo;
	
	@NonNull
	@Column(nullable = false)
	private String productquestionTitle;
	
	@NonNull
	@Column(nullable = false)
	private String productquestionContent;
	
	@NonNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date productquestionRegdate;
	
	@NonNull
	@Column(nullable = false)
	private Integer productquestionPublication;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="productCode")
	private Product productCode;
	
	

	

}