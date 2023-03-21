package shop.myshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.myshop.annotation.MySecured;
import shop.myshop.dto.Role;
import shop.myshop.dto.UserDTO;
import shop.myshop.entity.User;
import shop.myshop.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
    private UserService userservice ;

//    @GetMapping()
//    public String index() {
//        return "index";
//    }
	
	@GetMapping("logo")
    public String index(HttpSession httpSession) {
		if(httpSession.getAttribute("user") == null) {
			 return "redirect:/index.html";
		}
		 return "redirect:/main.html";
    }

    @GetMapping("login")
    public String login(Model model, HttpSession httpSession) throws Exception{
        if (httpSession.getAttribute("user") != null) {
            User user = (User) httpSession.getAttribute("user");
            model.addAttribute("user", user);
            return "redirect:user/my-info";
        }
        return "user/login-form";
    }
    //
    @PostMapping("login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("password") String password, HttpSession httpSession) throws Exception{
        if (!userservice.isUser(id, password)) {
            return "redirect:loginfail";
        }
        
        httpSession.setAttribute("user", userservice.findByUserId(id));
        return "redirect:/main.html";
    }
    
    @GetMapping("loginfail")
    public String loginfail(Model model, HttpSession httpSession) throws Exception{
        return "user/login-fail";
    }
    //같은 역할을 하는 컨트롤러가 2개가 됨 !!로그인 실패시 메시지만 보내는 형식으로 수정 필요
    @PostMapping("loginfail")
    public String loginfail(@RequestParam("id") String id,
                        @RequestParam("password") String password, HttpSession httpSession) throws Exception{
        if (!userservice.isUser(id, password)) {
            return "redirect:loginfail";
        }
        
        httpSession.setAttribute("user", userservice.findByUserId(id));
        return "redirect:/main.html";
    }
    
    //USER이상의 회원만 로그아웃가능
    @MySecured(role = Role.USER)
    @GetMapping("logout")
    public String logout(HttpSession httpSession) throws Exception{
        httpSession.invalidate();
        return "redirect:/index.html";
    }

    @GetMapping("my-info")
    public String myInfo(Model model, HttpSession httpSession) throws Exception{
        if (httpSession.getAttribute("user") != null) {
        	
            UserDTO user = (UserDTO) httpSession.getAttribute("user");
            System.out.println("-----"+user);
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new UserDTO());
        }

        return "user/my-info";
    }
}
