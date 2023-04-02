package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.OrderItem;
import shop.myshop.entity.Orders;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	//------▲영림 ------ ▼윤영--------------------------------------------------------------------------	
	
	
	
    
	
}
