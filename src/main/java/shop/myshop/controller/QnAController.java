package shop.myshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.myshop.dto.UserDTO;

@Controller
@RequestMapping("qna")
public class QnAController {
	
	
	
	
	@GetMapping("/qnalist")
	 public String qnalist() {
       
		 return "board/qna-list.html";
    }
	
	
	@GetMapping("qnawriteform")
	public String qnawriteForm(HttpSession session, Model model) throws Exception {
		UserDTO user = (UserDTO) session.getAttribute("user");

		model.addAttribute("user", user);

		return "board/qna-write";
	}
	

}
