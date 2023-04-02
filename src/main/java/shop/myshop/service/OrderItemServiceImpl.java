package shop.myshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.entity.OrderItem;
import shop.myshop.entity.Orders;
import shop.myshop.repository.OrderItemRepository;
import shop.myshop.repository.OrdersRepository;


@Service
public class OrderItemServiceImpl implements OrderItemService{
	
	@Autowired
	private OrderItemRepository orderItemDao;
	
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public void orderItemrSave(OrderItem orderItem) {
		orderItemDao.save(orderItem);
	}
	

}
	

	
	
	
