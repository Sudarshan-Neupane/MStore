package mum.edu.mstore.controller;

import javax.servlet.http.HttpServletRequest;

import mum.edu.mstore.domain.Product;
import mum.edu.mstore.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(Model model, Product product) {
		model.addAttribute("categories", categoryService.findAll());
		return "home";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String searchProduct(@ModelAttribute Product product, Model model, HttpServletRequest request) {
		
		//Search on the basis of Category Subcategory and Album
		//Search on the basis of Category and Subcategory
		//Search on the basis of Subcategory and Album
		System.out.println(product.getAlbum().getName());
		System.out.println(product.getCategory().getName());
		return "home";
	}
}
