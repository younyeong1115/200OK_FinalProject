package shop.myshop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productCode;
	private String productPrice;
	private String productThumbNail;
	private String productImage1;
	private String productImage2;
	private String productPostingYn;
	private String productSaleingYn;
	private Integer productSize;
	private Integer productStock;
	private Integer productSale;
	private String productDetail;
	private Integer categoryNo;
	
}
