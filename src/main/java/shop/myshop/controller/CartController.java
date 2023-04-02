package shop.myshop.controller;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.myshop.dto.UserDTO;
import shop.myshop.entity.Cart;
import shop.myshop.entity.Product;
import shop.myshop.service.CartService;
import shop.myshop.service.DeliveryService;
import shop.myshop.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartService cartservice;

	@Autowired
	private ProductService productservice;
	
	@Autowired
	private DeliveryService deliveryservice;

	// 장바구니 폼으로 이동
	@GetMapping("cartform")
	public String cartForm(HttpSession session, Model model) throws Exception {

		UserDTO user = (UserDTO) session.getAttribute("user");

		// userId로 검색해서 cart의 상품 정보 가져오기
		List<Product> product = cartservice.getProductCode(user.getUserId());

		List<Integer> CartQuantity = cartservice.getCartQuantity(user.getUserId());

		model.addAttribute("product", product);
		model.addAttribute("quantity", CartQuantity);

		// 총가격 구하기
		int totalPrice = 0;
		for (int i = 0; i < product.size(); i++) {

			// 리스트에 있는 물건 가격 integer로 변환 후 totalPrice에 더하기
			totalPrice += Integer.parseInt(product.get(i).getProductPrice()) * CartQuantity.get(i);
		}
		model.addAttribute("totalPrice", totalPrice);

		return "product/cart";
	}

	@PostMapping("addcart")
	public String addCart(HttpSession session, @RequestBody Map<String, Object> jsonData,
			RedirectAttributes redirectAttributes, Model model) {

		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, String>> selectedProducts = mapper.convertValue(jsonData.get("products"),
				new TypeReference<List<Map<String, String>>>() {
				});

		session.setAttribute("selectedProducts", selectedProducts);

		return "product/order";
	}

	@GetMapping("orderform")
	public String orderForm(HttpSession session, Model model) throws Exception {

		model.addAttribute("selectedProducts", session.getAttribute("selectedProducts"));
		System.out.println(session.getAttribute("selectedProducts"));
		// 세션에 저장된 selectedProducts list 가져오기
		List<Map<String, String>> selectedProducts = (List<Map<String, String>>) model.getAttribute("selectedProducts");

		// selectedProducts에서 productCode,quantity를 분리
		List<Integer> productCodeList = new ArrayList<>();
		List<Integer> quantityList = new ArrayList<>();
		for (Map<String, String> map : selectedProducts) {
			productCodeList.add(Integer.parseInt(map.get("productCode")));
			quantityList.add(Integer.parseInt(map.get("quantity")));
		}

		// product 객체를 list에 담기
		ArrayList<Product> list = new ArrayList<>();
		for (int i = 0; i < productCodeList.size(); i++) {
			list.add(productservice.findByProductCode(productCodeList.get(i)));
		}

		// 총합 계산
		int totalPrice = 0; //구매 총 금액 
		ArrayList<Integer> priceList = new ArrayList<Integer>();//물건 * 갯수 (개별금액)
		for (int i = 0; i < productCodeList.size(); i++) {
			Product product = productservice.findByProductCode(productCodeList.get(i));
			int quantity = quantityList.get(i);
			priceList.add(Integer.parseInt(product.getProductPrice()) * quantity);
			totalPrice += Integer.parseInt(product.getProductPrice()) * quantity;
			
		}
		UserDTO user = (UserDTO) session.getAttribute("user");
		//딜리버리 서비스에서 deliveryDao.findBydeliveryBasicynAndDeliveryId(userId);이거 가져와서 기본 배송지 초기화
		model.addAttribute("delivery", deliveryservice.findBydeliveryBasicynAndDeliveryId(user.getUserId()));
		model.addAttribute("user", user);
		model.addAttribute("totalPrice", totalPrice + 3000);
		model.addAttribute("product", list);
		model.addAttribute("quantity", quantityList);
		model.addAttribute("price", priceList);

		return "product/order.html";
	}

	// 오더 폼에서 다른 페이지로 넘어갈때 세션에 저장된 selectedProducts 지우기!

}
