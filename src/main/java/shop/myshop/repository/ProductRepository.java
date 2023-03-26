package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	
//------▲영림 ------ ▼윤영--------------------------------------------------------------------------

	
}
