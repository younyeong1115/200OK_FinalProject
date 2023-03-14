package shop.myshop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

@Entity
public class Manager {
	@Id
	private String managerId;	
	private String userPwd;
	private String managerName;
	
	
}
