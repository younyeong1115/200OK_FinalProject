package shop.myshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import shop.myshop.dto.UserDTO;
import shop.myshop.entity.User;


@Transactional
@Service
public interface UserService {
	

	public User join(User user) throws Exception;
	public Boolean isUser(String id, String pwd) throws Exception;
	public UserDTO findByUserId(String id) throws Exception;
	public List<UserDTO> findAll() throws Exception;

	public String getUserId(String userName, String userEmail) throws Exception;
	
}
