package shop.myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.myshop.entity.Product;
import shop.myshop.service.CategoryService;


@Controller
@RequestMapping("category")
public class CategoryController {

	
	@Autowired 
	private CategoryService categoryService;
	
	
	
	  
	
}
