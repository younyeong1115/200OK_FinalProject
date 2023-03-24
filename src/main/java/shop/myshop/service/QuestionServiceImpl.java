package shop.myshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.repository.QuestionRepository;


@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository qestionDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int getQuestionCount(String userId) {
		return qestionDao.getQuestionwCount(userId);
	}
	

}
	

	
	
	
