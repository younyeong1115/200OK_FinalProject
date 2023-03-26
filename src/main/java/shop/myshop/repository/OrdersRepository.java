package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {
	
	//------▲영림 ------ ▼윤영--------------------------------------------------------------------------	
	
	@Query("SELECT COUNT(o) FROM Orders o WHERE o.userId.userId=:userId and orderStatus=:orderStatus")
	int getOrdersCount(@Param("userId") String userId ,@Param("orderStatus") String orderStatus);
    
	
}
