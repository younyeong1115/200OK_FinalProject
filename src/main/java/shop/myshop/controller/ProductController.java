package shop.myshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.myshop.dto.ProductDTO;
import shop.myshop.entity.Category;
import shop.myshop.service.CategoryService;
import shop.myshop.service.ProductService;


@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired 
	private CategoryService categoryService;
	
	
	
	@GetMapping("ringForm")
	 public String ringlist() {
      
		 return "product/ringlist";
   }
	
	
	@GetMapping("/ringlist")
	public String getRingProducts(Model model) {
	    // 카테고리 번호 4, 5, 6에 해당하는 Category 객체를 조회
	    Category category4 = categoryService.getCategoryByCategoryNo(4);
	    System.out.println(category4);
	    Category category5 = categoryService.getCategoryByCategoryNo(5);
	    Category category6 = categoryService.getCategoryByCategoryNo(6);

	    // 조회된 카테고리에 해당하는 제품들을 가져온다
	    List<ProductDTO> productList4 = productService.getProductListByCategory(category4);
	    List<ProductDTO> productList5 = productService.getProductListByCategory(category5);
	    List<ProductDTO> productList6 = productService.getProductListByCategory(category6);

	    // 모델에 조회된 제품 리스트들을 추가한다
	    model.addAttribute("productList4", productList4);
	    System.out.println(productList4);
	    model.addAttribute("productList5", productList5);
	    model.addAttribute("productList6", productList6);

	    return "product/ringlist";
	}

	
}
