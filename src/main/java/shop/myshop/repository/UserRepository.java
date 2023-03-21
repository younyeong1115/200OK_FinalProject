package shop.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, String>{
	 List<User> findByUserIdAndUserPwd(String id, String pwd) throws Exception;
    User findByUserId(String id) throws Exception;
	
}
