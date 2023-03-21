package shop.myshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import shop.myshop.dto.UserDTO;
import shop.myshop.entity.User;


@Transactional
@Service
public interface UserService {
	
	public User join(User user) throws Exception;

	
	Boolean isUser(String id, String pwd) throws Exception;
    UserDTO findByUserId(String id) throws Exception;
    List<UserDTO> findAll() throws Exception;
	
	
}
