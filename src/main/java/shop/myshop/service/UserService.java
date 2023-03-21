package shop.myshop.service;

import java.util.List;

import shop.myshop.dto.UserDTO;

public interface UserService {
    Boolean isUser(String id, String pwd) throws Exception;
    UserDTO findByUserId(String id) throws Exception;
    List<UserDTO> findAll() throws Exception;
}