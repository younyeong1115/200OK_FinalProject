package shop.myshop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import shop.myshop.entity.OrderItem;


@Transactional
@Service
public interface OrderItemService {
	
	public void orderItemrSave(OrderItem orderItem) ;
	
	
}
