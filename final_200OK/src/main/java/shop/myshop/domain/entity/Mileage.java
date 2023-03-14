package shop.myshop.domain.entity;

import java.util.Date;

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

@Entity
public class Mileage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mileageCode;	
	@Temporal(TemporalType.TIMESTAMP)
	private  Date mileageRegdate;
	private String mileageContent;
	private Integer mileagePrice;
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	
	
}
