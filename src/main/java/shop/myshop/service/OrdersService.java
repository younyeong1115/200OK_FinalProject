package shop.myshop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import shop.myshop.entity.Orders;


@Transactional
@Service
public interface OrdersService {
	
	public int getOrdersCount(String userId,String orderStatus);
	
	public void orderSave(Orders orders);
}
