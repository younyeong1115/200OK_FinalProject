package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	
	
	@Query("SELECT COUNT(q) FROM Question q WHERE q.userId.userId = :userId")
	int getQuestionwCount(@Param("userId") String userId);

}
