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
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer answerNo;
	private String answerContent;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date answerRegdate;
	
	private String managerId;
	private Integer questionNo;

}
