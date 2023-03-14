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
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qusetionNo;
	private String qusetionTitle;
	private String qusetionContent;
	@Temporal(TemporalType.TIMESTAMP)
	private Date qusetionRegdate;
	private String qusetionCategory;
	private Integer qusetionPublication;
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	
}