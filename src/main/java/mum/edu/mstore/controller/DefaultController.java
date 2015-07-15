package mum.edu.mstore.controller;

import mum.edu.mstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mum.edu.mstore.domain.Product;
import mum.edu.mstore.service.ProductService;

@Controller
public class DefaultController {

    @Autowired
	private CategoryService categoryService;
//     @Autowired
//        private ProductService productService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(Model model, Product product) {
         model.addAttribute("categories", categoryService.findAll());
//         model.addAttribute("product", productService.findAll());
	return "home";
	}
}
