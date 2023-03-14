package shop.myshop.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

@Entity(name = "manager")
public class Manager {
	@Id
	private String managerId;	
	private String userPwd;
	private String managerName;
	
	@OneToMany(mappedBy = "managerId")
	private List<Answer> answer= new ArrayList<Answer>();
	
	@OneToMany(mappedBy = "managerId")
	private List<Notice> notice= new ArrayList<Notice>();
	
	@OneToMany(mappedBy = "managerId")
	private List<ProductAnswer> productanswer= new ArrayList<ProductAnswer>();
	
	
	
	
}
