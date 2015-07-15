package mum.edu.mstore.controller;

import mum.edu.mstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mum.edu.mstore.domain.Product;

@Controller
public class DefaultController {

    @Autowired
	private CategoryService categoryService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(Model model, Product product) {
         model.addAttribute("categories", categoryService.findAll());
	return "home";
	}
}
