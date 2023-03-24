package shop.myshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int getCartCount(String userId) {
		return cartDao.getCartCount(userId);
	}
	

}
	

	
	
	
