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
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noticeNo;
	private String managerId;
	private String noticeTitle;
	private String noticeContent;
	@Temporal(TemporalType.TIMESTAMP)
	private Date noticeRegdate;
	private Integer noticeCategory;
	private String noticeImage;

}