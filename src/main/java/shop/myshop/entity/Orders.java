package shop.myshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.dto.Role;

@DynamicInsert // (insert 시 null 인필드 제외)
@DynamicUpdate // (update 시 null 인필드 제외)
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	@JoinColumn(name = "userId")
	private User userId;

	@Temporal(TemporalType.TIMESTAMP)
	@NonNull
	@Column(nullable = false)
	private Date orderRegdate;

	@NonNull
	@Column(nullable = false)
	private String orderPayment;

	@OneToOne
	@NonNull
	@JoinColumn(name = "deliveryId")
	private Delivery deliveryId;

	@NonNull
	@Column(nullable = false)
	private String orderStatus;
	
	@NonNull
	@Column(nullable = false)
	private String orderTotalPrice;
	

	@OneToMany(mappedBy = "orderCode")
	private List<OrderItem> orderitem = new ArrayList<OrderItem>();

	@OneToMany(mappedBy = "orderCode")
	private List<Review> review = new ArrayList<Review>();

	@Override
	public String toString() {
		return "Orders{" + "orderCode=" + orderCode + ", userId=" + userId.getUserId() + ", orderRegdate="
				+ orderRegdate + ", orderPayment='" + orderPayment
				+ ' ' + ", deliveryId=" + deliveryId.getDeliveryId() + ", orderStatus='" + orderStatus + ' ' + '}';
	}

}
