package shop.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Category;
import shop.myshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value="select p from Product p where p.categoryNo=:categoryNo")
	 List<Product> findByCategoryNo(@Param("categoryNo")Category categoryNo);
	
//------▲영림 ------ ▼윤영--------------------------------------------------------------------------

	Product findByProductCode(@Param("productCode")int productCode);
	
}
