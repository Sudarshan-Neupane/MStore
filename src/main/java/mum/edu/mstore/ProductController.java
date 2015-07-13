package mum.edu.mstore;

import mum.edu.mstore.domain.Product;
import mum.edu.mstore.domain.ProductFile;
import mum.edu.mstore.domain.ProductFile.FileType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showProduct(Model model) {
		Product product = new Product();
		ProductFile pf = new ProductFile();
		pf.setFilePath("asdf");
		product.addProductFile(pf);
        System.out.println(product.getProductFile());
		model.addAttribute("productFiles",product.getProductFile());
		model.addAttribute("product", product);
		model.addAttribute("fileType", FileType.values());

		return  "addProduct";
	}
	
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product) {

		return "redirect:/product/";
	}

}
