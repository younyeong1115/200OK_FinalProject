package shop.myshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

	@NonNull
	@Column(nullable = false)
	private String orderStatus;

	@NonNull
	@Column(nullable = false)
	private String orderTotalprice;

	@NonNull
	@Column(nullable = false)
	private String deliveryName;

	@NonNull
	@Column(nullable = false)
	private String deliveryMobile;

	@NonNull
	@Column(nullable = false)
	private String deliveryAdd1;

	@NonNull
	@Column(nullable = false)
	private String deliveryAdd2;

	@Column(nullable = true)
	private String deliveryAdd3;

	@Column(nullable = true)
	private String deliveryMemo;

	@OneToMany(mappedBy = "orderCode", cascade = CascadeType.ALL)
	private List<OrderItem> orderitem = new ArrayList<OrderItem>();

	@OneToMany(mappedBy = "orderCode", cascade = CascadeType.ALL)
	private List<Review> review = new ArrayList<Review>();


	@Override
	public String toString() {
		return "Orders{" + "orderCode=" + orderCode + ", userId=" + userId.getUserId() + ", orderRegdate="
				+ orderRegdate + ", orderPayment='" + orderPayment + ' ' + ", orderStatus='" + orderStatus + ' '
				+ ", deliveryName='" + deliveryName + ' ' + ", deliveryMobile='" + deliveryMobile + ' '
				+ ", deliveryAdd1='" + deliveryAdd1 + ' ' + ", deliveryAdd2='" + deliveryAdd2 + ' ' + ", deliveryAdd3='"
				+ deliveryAdd3 + ' ' + ", deliveryMemo='" + deliveryMemo + ' ' + '}';
	}

}
