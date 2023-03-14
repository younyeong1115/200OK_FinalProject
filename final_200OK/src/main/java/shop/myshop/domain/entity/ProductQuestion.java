package shop.myshop.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class ProductQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productquestionNo;
	private String productquestionTitle;
	private String productquestionContent;
	@Temporal(TemporalType.TIMESTAMP)
	private Date productquestionRegdate;
	private Integer productquestionPublication;
	private String userId;
	private Integer productCode;

	

}