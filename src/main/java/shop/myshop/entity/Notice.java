package shop.myshop.entity;

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
@Entity(name = "notice")
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noticeNo;
	@ManyToOne
	@NonNull
	@JoinColumn(name="userId")
	private User userId;
	private String noticeTitle;
	private String noticeContent;
	@Temporal(TemporalType.TIMESTAMP)
	private Date noticeRegdate;
	private Integer noticeCategory;
	private String noticeImage;

}