package shop.myshop.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.entity.Product;
import shop.myshop.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int getCartCount(String userId) throws Exception{
		return cartDao.getCartCount(userId) ;
	}

	@Override
	public List<Product> getProductCode(String userId) throws Exception{
		return cartDao.getProductCode(userId);
	}
	
	@Override
	public List<Integer> getCartQuantity(String userId) throws Exception{
		return cartDao.getCartQuantity(userId);
	}

}
	

	
	
	
