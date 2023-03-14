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
public class ProductAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productanswerNo;
	private String productanswerContent;
	@Temporal(TemporalType.TIMESTAMP)
	private Date productanswerRegdate;
	private String managerId;
	private Integer productCode;
	

}
