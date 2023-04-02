package shop.myshop.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import shop.myshop.dto.UserDTO;
import shop.myshop.entity.Orders;
import shop.myshop.entity.User;
import shop.myshop.service.CartService;
import shop.myshop.service.OrdersService;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrdersService ordersService;


	
	
// ------▲영림 ------ ▼윤영---------------------------------------------------------------------------


	@GetMapping("payment")
	public String handlePaymentRequest(HttpSession session, @RequestParam("orderTotalprice") String orderTotalprice,
			@RequestParam("deliveryName") String deliveryName, @RequestParam("deliveryMobile") String deliveryMobile,
			@RequestParam("deliveryAdd1") String deliveryAdd1, @RequestParam("deliveryAdd2") String deliveryAdd2,
			@RequestParam("deliveryAdd3") String deliveryAdd3, @RequestParam("deliveryMemo") String deliveryMemo) {
		
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

		return "product/success-payment";
	}


}
