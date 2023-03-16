package shop.myshop.entity;

import java.util.Date;

import javax.persistence.Column;
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
@Entity(name="answer")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer answerNo;
	
	@NonNull
	@Column(nullable = false)
	private String answerContent;
	
	@NonNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date answerRegdate;
	
	@OneToOne
	@Column(nullable = false)
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
	@OneToOne
	@Column(nullable = false)
	@NonNull
	@JoinColumn(name="qusetionNo")
	private Question questionNo;

}
