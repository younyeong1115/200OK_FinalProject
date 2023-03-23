package shop.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, String>{
	 List<User> findByUserIdAndUserPwd(String id, String pwd) throws Exception;
     User findByUserId(String id) throws Exception;
    
    
    @Query(value = "select u.userId from User u  where u.userName=:userName and u.userEmail=:userEmail", nativeQuery = true)
    String findByUserNameAndUserEmail(@Param("userName")String userName, @Param("userEmail")String userEmail) throws Exception;
    
    
}
