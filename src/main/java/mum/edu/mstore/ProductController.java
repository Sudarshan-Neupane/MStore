package mum.edu.mstore;

import mum.edu.mstore.domain.Product;
import mum.edu.mstore.domain.ProductFile;
import mum.edu.mstore.domain.ProductFile.FileType;
import mum.edu.mstore.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	CategoryService categoryService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showProduct(Product product, Model model) {
		/*Product product = new Product();
		ProductFile pf = new ProductFile();
		pf.setFilePath("asdf");
        System.out.println(product.getProductFile());
		model.addAttribute("productFiles",product.getProductFile());
		model.addAttribute("product", product);
		model.addAttribute("fileType", FileType.values());*/
		
		System.out.println(categoryService.findAll());
		model.addAttribute("categories",categoryService.findAll());
		model.addAttribute("subcategories",categoryService.findAll());

		return  "addProduct";
	}
	
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product) {

		System.out.println("inside add product post");
		return "redirect:/product/";
	}

}
