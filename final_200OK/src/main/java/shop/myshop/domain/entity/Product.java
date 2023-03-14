package shop.myshop.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Entity(name = "product")
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
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="categoryNo")
	private Category categoryNo;
	
	@OneToMany(mappedBy = "productCode")
	private List<Likes> likes = new ArrayList<Likes>();
	
	@OneToMany(mappedBy = "productCode")
	private List<Cart> cart = new ArrayList<Cart>();

	@OneToMany(mappedBy = "productCode")
	private List<NonUserOrderDetail> nonuserorderdetail = new ArrayList<NonUserOrderDetail>();
	
	@OneToMany(mappedBy = "productCode")
	private List<OrderDetail> orderdetail = new ArrayList<OrderDetail>();
	
	@OneToMany(mappedBy = "productCode")
	private List<Review> Review = new ArrayList<Review>();
	
	@OneToMany(mappedBy = "productCode")
	private List<ProductQuestion> productquestion = new ArrayList<ProductQuestion>();
	
	
}
