package shop.myshop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Transactional
@Service
public interface CartService {
	
	public int getCartCount(String userId);
}
