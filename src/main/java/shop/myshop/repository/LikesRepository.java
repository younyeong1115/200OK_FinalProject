package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {
	
	//------▲영림 ------ ▼윤영--------------------------------------------------------------------------
	
	
	@Query("SELECT COUNT(l) FROM Likes l WHERE l.userId.userId = :userId") 
		int getLikesCount(@Param("userId") String userId);
	 

}
