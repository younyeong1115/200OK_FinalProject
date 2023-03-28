package shop.myshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.myshop.dto.DeliveryDTO;
import shop.myshop.dto.UserDTO;
import shop.myshop.entity.Delivery;
import shop.myshop.service.CartService;
import shop.myshop.service.DeliveryService;
import shop.myshop.service.LikesService;
import shop.myshop.service.OrdersService;
import shop.myshop.service.ProductQuestionService;
import shop.myshop.service.QuestionService;
import shop.myshop.service.ReviewService;

@Controller
@RequestMapping("mypage")
public class MyPageController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private LikesService likesService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ProductQuestionService productQuestionService;
	
	@Autowired
	private OrdersService orderService;
	
	@Autowired
	private DeliveryService deliveryService;
	
	
	
	
	//회원 정보 수정 폼
	@GetMapping("edituserform")
	public String EditUserForm(Model model,HttpSession httpSession) throws Exception {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		model.addAttribute("user",user);
		return "user/user-update";
	}
	//회원 정보 수정
	@GetMapping("edituser")
	public String Edituser() throws Exception {
		
		return "user/my-info";
	}
	
	//배송지 목록
	@GetMapping("adresslist")
	public String Adresslist(Model model, HttpSession httpSession) throws Exception {
		
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("delivery",deliveryService.getByUserId(user.getUserId()));
		
		
		return "user/adress-list";
	}
	
	@GetMapping("home")
	public String myInfo(Model model, HttpSession httpSession) throws Exception {
		if (httpSession.getAttribute("user") != null) {

			UserDTO user = (UserDTO) httpSession.getAttribute("user");
			//목록
			model.addAttribute("cartCount", cartService.getCartCount(user.getUserId()));
			model.addAttribute("LikesCount", likesService.getLikesCount(user.getUserId()));
			model.addAttribute("BoardCount", reviewService.getReviewCount(user.getUserId()) + questionService.getQuestionCount(user.getUserId())  +  productQuestionService.getProductQuestionCount(user.getUserId()));//리뷰 + 상품 질문 + 질문
			//배송상태
			model.addAttribute("beforeDeposit", orderService.getOrdersCount(user.getUserId(), "입금전"));
			model.addAttribute("PreparingProduct", orderService.getOrdersCount(user.getUserId(), "상품준비중"));
			model.addAttribute("shipping", orderService.getOrdersCount(user.getUserId(), "배송중"));
			model.addAttribute("completed", orderService.getOrdersCount(user.getUserId(), "배송완료"));
			
			model.addAttribute("user", user);
		} 
		return "user/my-info";
	}
	//배송지 추가 페이지로 이동
	@GetMapping("deliveryaddform")
	public String deliveryAddForm(HttpSession session,Model model) throws Exception {
		UserDTO user = (UserDTO) session.getAttribute("user");
		model.addAttribute("user", user);
		return "user/address-add";
	}
	
	//기본 배송지 추가/수정
	@PostMapping("deliveryadd")
	public String deliveryAdd(DeliveryDTO delivery,HttpSession session) throws Exception {
		System.out.println(delivery);
		//기본 배송지 설정을 선택 한 경우
		if(delivery.getDeliveryBasicyn().equals("Y")) {
			
			UserDTO user = (UserDTO) session.getAttribute("user");
			//Y(기본 배송지)로 설정된 DeliveryId를 가져온 후 N으로 수정해줌
			
			if(deliveryService.getByDeliveryId(user.getUserId()) != null) {
				deliveryService.updateBasicyn(deliveryService.getByDeliveryId(user.getUserId()));
			}
			
			
		}
		
		deliveryService.save(delivery);
		return "redirect:/mypage/adresslist";
	}
	//배송지 수정 페이지로 이동
	@GetMapping("deliveryupdateform")
	public String deliveryUpdateForm(HttpSession session,Model model,@RequestParam(value = "deliveryId")Integer deliveryId) throws Exception {
		UserDTO user = (UserDTO) session.getAttribute("user");
		DeliveryDTO delivery = deliveryService.findByDeliveryId(deliveryId);
		model.addAttribute("delivery", delivery);
		model.addAttribute("user", user);
		return "user/address-update";
	}
	
	//배송지 삭제(비동기)
	@GetMapping("deliverydelete")
	public String deliveryDelte(@RequestParam(value = "deliveryId")Integer deliveryId) throws Exception {
		System.out.println("머냐고 ----" + deliveryId);
		
		deliveryService.deleteByDeliveryId(deliveryId);
		
		return "redirect:/mypage/adresslist";
	}
	
	

}