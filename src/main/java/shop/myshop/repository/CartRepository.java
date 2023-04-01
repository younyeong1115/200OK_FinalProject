package shop.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Cart;
import shop.myshop.entity.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	//------▲영림 ------ ▼윤영--------------------------------------------------------------------------
	
	//마이페이지 장바구니 갯수
	@Query("SELECT COUNT(c) FROM Cart c WHERE c.userId.userId = :userId")
	int getCartCount(@Param("userId") String userId) throws Exception;
	
	//userId로 cart에 담긴 product 정보 가지고 오기
	@Query("SELECT c.productCode FROM Cart c WHERE c.userId.userId = :userId")
	List<Product> getProductCode(@Param("userId") String userId) throws Exception;
	
	@Query("SELECT c.cartQuantity FROM Cart c WHERE c.userId.userId = :userId")
	List<Integer> getCartQuantity(@Param("userId") String userId) throws Exception;

}
