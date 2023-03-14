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
	private String userId;
	
}