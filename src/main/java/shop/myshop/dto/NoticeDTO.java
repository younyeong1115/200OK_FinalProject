package shop.myshop.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NoticeDTO {
	
	private Integer noticeNo;
	private String userId;
	private String noticeTitle;
	private String noticeContent;
	private Timestamp noticeRegdate;
	private Integer noticeCategory;
	private String noticeImage;

}
