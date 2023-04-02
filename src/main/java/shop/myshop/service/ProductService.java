package shop.myshop.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import shop.myshop.dto.ProductDTO;
import shop.myshop.entity.Category;
import shop.myshop.entity.Product;


@Service
public interface  ProductService {
	
	


	List<ProductDTO> getProductListByCategory(Category categoryNo);
	
//----------------------------------------------------------------------
	Product findByProductCode(@Param("productCode")int productCode);



}