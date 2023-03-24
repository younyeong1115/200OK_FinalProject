package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	@Query("SELECT COUNT(c) FROM Cart c WHERE c.userId.userId = :userId")
	int getCartCount(@Param("userId") String userId);

}
