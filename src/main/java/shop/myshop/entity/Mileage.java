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

@Entity
public class Mileage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mileageCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NonNull
	@Column(nullable = false)
	private  Date mileageRegdate;
	
	@NonNull
	@Column(nullable = false)
	private String mileageContent;
	
	@NonNull
	@Column(nullable = false)
	private Integer mileagePrice;

	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	
	
}
