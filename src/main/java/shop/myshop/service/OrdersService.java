package shop.myshop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Transactional
@Service
public interface OrdersService {
	
	public int getOrdersCount(String userId,String orderStatus);
}
