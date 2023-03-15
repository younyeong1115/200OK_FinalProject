package shop.myshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryNo;
	private String categoryMain;
	private String categorySub;
	
	
	@OneToMany(mappedBy = "categoryNo")
	private List<Product> product = new ArrayList<Product>();
}
