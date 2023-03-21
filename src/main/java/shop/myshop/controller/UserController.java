package shop.myshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.myshop.annotation.MySecured;
import shop.myshop.dto.Role;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@MySecured(role = Role.USER)
    @GetMapping
    public String user() {
        return "user page";
    }

}
