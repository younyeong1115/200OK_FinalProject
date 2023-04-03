package shop.myshop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.myshop.dto.UserDTO;
import shop.myshop.entity.OrderItem;
import shop.myshop.entity.Orders;
import shop.myshop.entity.User;
import shop.myshop.service.CartService;
import shop.myshop.service.OrderItemService;
import shop.myshop.service.OrdersService;
import shop.myshop.service.ProductService;

@Controller
@RequestMapping("order")
public class OrderController {


	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;




	
	
// ------▲영림 ------ ▼윤영---------------------------------------------------------------------------


	@GetMapping("payment")
	public String handlePaymentRequest(HttpSession session, @RequestParam("orderTotalprice") String orderTotalprice,
			@RequestParam("deliveryName") String deliveryName, @RequestParam("deliveryMobile") String deliveryMobile,
			@RequestParam("deliveryAdd1") String deliveryAdd1, @RequestParam("deliveryAdd2") String deliveryAdd2,
			@RequestParam("deliveryAdd3") String deliveryAdd3, @RequestParam("deliveryMemo") String deliveryMemo) throws Exception {
		
		UserDTO userDTO = (UserDTO) session.getAttribute("user");
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userDTO, User.class);

		Orders order = new Orders();

		order.setUserId(user);
		Date regdate = new Date();
		order.setOrderRegdate(regdate);
		order.setOrderPayment("무통장입금");
		order.setOrderStatus("입금전");
		order.setOrderTotalprice(orderTotalprice);
		order.setDeliveryName(deliveryName);
		order.setDeliveryMobile(deliveryMobile);
		order.setDeliveryAdd1(deliveryAdd1);
		order.setDeliveryAdd2(deliveryAdd2);
		order.setDeliveryAdd3(deliveryAdd3);
		order.setDeliveryMemo(deliveryMemo);

		ordersService.orderSave(order);
		
		//주문 품목 장바구니 삭제 ,오더 아이템 추가
		List<Map<String, String>> selectedProducts = (List<Map<String, String>>) session.getAttribute("selectedProducts");
		List<Integer> productCodeList = new ArrayList<>();
		List<Integer> quantityList = new ArrayList<>();
		for (Map<String, String> map : selectedProducts) {
			productCodeList.add(Integer.parseInt(map.get("productCode")));
			quantityList.add(Integer.parseInt(map.get("quantity")));
		}
		
		for(int i =0; i<productCodeList.size();i++) {
			cartService.deleteByUserIdAndProductCode(user.getUserId(), productCodeList.get(i));
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderCode(order);
			orderItem.setOrderitemQuantity(quantityList.get(i));
			orderItem.setProductCode(productService.findByProductCode(productCodeList.get(i)));
			orderItemService.orderItemrSave(orderItem);
		}
		
		//selectedProducts 세션에서 삭제


		return "product/success-payment";
	}

	
	
	
	@GetMapping("paymentapi")
	public String handlePaymentapiRequest(HttpSession session, @RequestParam("orderTotalprice") String orderTotalprice,
			@RequestParam("deliveryName") String deliveryName, @RequestParam("deliveryMobile") String deliveryMobile,
			@RequestParam("deliveryAdd1") String deliveryAdd1, @RequestParam("deliveryAdd2") String deliveryAdd2,
			@RequestParam("deliveryAdd3") String deliveryAdd3, @RequestParam("deliveryMemo") String deliveryMemo) throws Exception {
		
		UserDTO userDTO = (UserDTO) session.getAttribute("user");
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userDTO, User.class);

		Orders order = new Orders();

		order.setUserId(user);
		Date regdate = new Date();
		order.setOrderRegdate(regdate);
		order.setOrderPayment("통합결제");
		order.setOrderStatus("결제완료");
		order.setOrderTotalprice(orderTotalprice);
		order.setDeliveryName(deliveryName);
		order.setDeliveryMobile(deliveryMobile);
		order.setDeliveryAdd1(deliveryAdd1);
		order.setDeliveryAdd2(deliveryAdd2);
		order.setDeliveryAdd3(deliveryAdd3);
		order.setDeliveryMemo(deliveryMemo);

		ordersService.orderSave(order);
		
		//주문 품목 장바구니 삭제 ,오더 아이템 추가
		List<Map<String, String>> selectedProducts = (List<Map<String, String>>) session.getAttribute("selectedProducts");
		List<Integer> productCodeList = new ArrayList<>();
		List<Integer> quantityList = new ArrayList<>();
		for (Map<String, String> map : selectedProducts) {
			productCodeList.add(Integer.parseInt(map.get("productCode")));
			quantityList.add(Integer.parseInt(map.get("quantity")));
		}
		
		for(int i =0; i<productCodeList.size();i++) {
			cartService.deleteByUserIdAndProductCode(user.getUserId(), productCodeList.get(i));
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderCode(order);
			orderItem.setOrderitemQuantity(quantityList.get(i));
			orderItem.setProductCode(productService.findByProductCode(productCodeList.get(i)));
			orderItemService.orderItemrSave(orderItem);
		}
		
		//selectedProducts 세션에서 삭제


		return "product/success-paymentapi";
	}

	
	
	
	
	
	
}
