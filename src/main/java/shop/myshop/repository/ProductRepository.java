package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	//사용자 정의ㅣ sql문장 자동 생성하는 메소드 등 선언

	
}
