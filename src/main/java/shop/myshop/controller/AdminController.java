package shop.myshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.myshop.annotation.MySecured;
import shop.myshop.dto.Role;

@RestController
@RequestMapping("/admin")
public class AdminController {
	

    @MySecured(role = Role.ADMIN)
    @GetMapping
    public String admin() {
        return "admin page";
    }

}
