package shop.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import shop.myshop.dto.ProductDTO;
import shop.myshop.entity.Category;
import shop.myshop.entity.Product;
import shop.myshop.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productDao;

	
	


	@Override
	public List<ProductDTO> getProductListByCategory(Category categoryNo) {
	    List<Product> productList = productDao.findByCategoryNo(categoryNo);
	    List<ProductDTO> productDtoList = new ArrayList<>();

	    for (Product product : productList) {
	        ProductDTO productDto = new ProductDTO();
	        BeanUtils.copyProperties(product, productDto);
	        productDtoList.add(productDto);
	    }

	    return productDtoList;
	}
	
	//----------------------------------------------------------------------
	
	@Override
	public Product findByProductCode(@Param("productCode")int productCode) {
			return productDao.findByProductCode(productCode);
		}
}





	
	

	

	
	
