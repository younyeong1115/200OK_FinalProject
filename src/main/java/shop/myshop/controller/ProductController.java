package shop.myshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.myshop.dto.ProductDTO;
import shop.myshop.entity.Category;
import shop.myshop.entity.Product;
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
	
	@GetMapping("braceletForm")
	 public String braceletlist() {
     
		 return "product/braceletlist";
  }
	@GetMapping("necklaceForm")
	 public String necklacelist() {
    
		 return "product/necklacelist";
 }
	@GetMapping("earingForm")
	 public String earinglist() {
   
		 return "product/earringlist";
		 
}
	@GetMapping("watchForm")
	 public String watchlist() {
  
		 return "product/watchlist";
}
	
	@GetMapping("objectForm")
	 public String objectlist() {
 
		 return "product/objectlist";
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

	@GetMapping("/braceletlist")
	public String getbraceletProducts(Model model) {
	    Category category7 = categoryService.getCategoryByCategoryNo(7);
	    Category category8 = categoryService.getCategoryByCategoryNo(8);
	    Category category9 = categoryService.getCategoryByCategoryNo(9);

	    List<ProductDTO> productList7 = productService.getProductListByCategory(category7);
	    List<ProductDTO> productList8 = productService.getProductListByCategory(category8);
	    List<ProductDTO> productList9 = productService.getProductListByCategory(category9);

	    // 모델에 조회된 제품 리스트들을 추가한다
	    model.addAttribute("productList7", productList7);
	    model.addAttribute("productList8", productList8);
	    model.addAttribute("productList9", productList9);

	    return "product/braceletlist";
	}
	
	
	@GetMapping("/necklacelist")
	public String getnecklaceProducts(Model model) {
	    Category category10 = categoryService.getCategoryByCategoryNo(10);
	    Category category11 = categoryService.getCategoryByCategoryNo(11);
	    Category category12 = categoryService.getCategoryByCategoryNo(12);

	    List<ProductDTO> productList10 = productService.getProductListByCategory(category10);
	    List<ProductDTO> productList11 = productService.getProductListByCategory(category11);
	    List<ProductDTO> productList12 = productService.getProductListByCategory(category12);

	    // 모델에 조회된 제품 리스트들을 추가한다
	    model.addAttribute("productList10", productList10);
	    model.addAttribute("productList11", productList11);
	    model.addAttribute("productList12", productList12);

	    return "product/necklacelist";
	}
	
	

	@GetMapping("/earringlist")
	public String getearringProducts(Model model) {
	    Category category1 = categoryService.getCategoryByCategoryNo(1);
	    Category category2 = categoryService.getCategoryByCategoryNo(2);
	    Category category3 = categoryService.getCategoryByCategoryNo(3);

	    List<ProductDTO> productList1 = productService.getProductListByCategory(category1);
	    List<ProductDTO> productList2 = productService.getProductListByCategory(category2);
	    List<ProductDTO> productList3 = productService.getProductListByCategory(category3);

	    // 모델에 조회된 제품 리스트들을 추가한다
	    model.addAttribute("productList1", productList1);
	    model.addAttribute("productList2", productList2);
	    model.addAttribute("productList3", productList3);

	    return "product/earringlist";
	}
	
	@GetMapping("/watchlist")
	public String getwatchProducts(Model model) {
	    Category category13 = categoryService.getCategoryByCategoryNo(13);
	    Category category14 = categoryService.getCategoryByCategoryNo(14);
	    Category category15 = categoryService.getCategoryByCategoryNo(15);

	    List<ProductDTO> productList13 = productService.getProductListByCategory(category13);
	    List<ProductDTO> productList14 = productService.getProductListByCategory(category14);
	    List<ProductDTO> productList15 = productService.getProductListByCategory(category15);

	    // 모델에 조회된 제품 리스트들을 추가한다
	    model.addAttribute("productList13", productList13);
	    model.addAttribute("productList14", productList14);
	    model.addAttribute("productList15", productList15);

	    return "product/watchlist";
	}
	
	@GetMapping("/objectlist")
	public String getobjectProducts(Model model) {
	    Category category16 = categoryService.getCategoryByCategoryNo(16);
	    Category category17 = categoryService.getCategoryByCategoryNo(17);
	    Category category18 = categoryService.getCategoryByCategoryNo(18);

	    List<ProductDTO> productList16 = productService.getProductListByCategory(category16);
	    List<ProductDTO> productList17 = productService.getProductListByCategory(category17);
	    List<ProductDTO> productList18 = productService.getProductListByCategory(category18);

	    // 모델에 조회된 제품 리스트들을 추가한다
	    model.addAttribute("productList16", productList16);
	    model.addAttribute("productList17", productList17);
	    model.addAttribute("productList18", productList18);

	    return "product/objectlist";
	}
	
	//--------------------------------------------------------------------------------------
	
		@GetMapping("productdetail/{productCode}")
		public String detail(@PathVariable int productCode, Model model,HttpSession httpSession) throws Exception {
			Product product = productService.findByProductCode(productCode);
			model.addAttribute("product", product);
			model.addAttribute("bonus", Integer.parseInt(product.getProductPrice())/100);
			
			//물건의 size가 s,m,l중 하나가 아닌 경우 one size 뷰로 이동 
//			if(!(product.getProductSize().equals("S")||product.getProductSize().equals("M")||product.getProductSize().equals("L"))) {
//				return "product/product-detail-onesize";
//			} 디벨롭 필요 상품사이즈별 옵션 사항
			

			return "product/product-detail-onesize";

		}


}
