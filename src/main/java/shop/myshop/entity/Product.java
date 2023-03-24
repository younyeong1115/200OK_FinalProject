package shop.myshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productCode;
	
	@NonNull
	@Column(nullable = false)
	private String productPrice;
	
	@NonNull
	@Column(nullable = false)
	private String productThumbNail;
	
	@NonNull
	@Column(nullable = false)
	private String productImage1;
	
	@NonNull
	@Column(nullable = false)
	private String productImage2;
	
	@NonNull
	@Column(nullable = false)
	private String productPostingYn;
	
	@NonNull
	@Column(nullable = false)
	private String productSaleingYn;
	
	@NonNull
	@Column(nullable = false)
	private Integer productSize;
	
	@NonNull
	@Column(nullable = false)
	private Integer productStock;
	
	@NonNull
	@Column(nullable = false)
	private Integer productSale;
	
	@NonNull
	@Column(nullable = false)
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
