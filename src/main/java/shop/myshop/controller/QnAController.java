package shop.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("qna")
public class QnAController {
	
	
	    
		@GetMapping("qnalist")
		 public String qnalist() {
	      
			 return "board/qna-list.html";
	   }
		
		
		
	    
	    
	 
	}


