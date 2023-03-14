package shop.myshop.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NonNull;
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
	
	@OneToOne
	@NonNull
	@JoinColumn(name="managerId")
	private Manager managerId;
	
	@OneToOne
	@NonNull
	@JoinColumn(name="qusetionNo")
	private Question questionNo;

}
