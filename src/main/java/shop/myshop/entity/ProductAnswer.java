package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Entity(name = "productanswer")
public class ProductAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productanswerNo;
	private String productanswerContent;
	@Temporal(TemporalType.TIMESTAMP)
	private Date productanswerRegdate;
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	@ManyToOne
	@NonNull
	@JoinColumn(name="productCode")
	private Product productCode;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="productquestionNo")
	private Question productquestionNo;

}