package shop.myshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.entity.Orders;
import shop.myshop.repository.OrdersRepository;


@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersRepository ordersDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int getOrdersCount(String userId,String orderStatus) {
		return ordersDao.getOrdersCount(userId, orderStatus);
	}
	@Override
	public void orderSave(Orders orders) {
		ordersDao.save(orders);
	}

}
	

	
	
	
