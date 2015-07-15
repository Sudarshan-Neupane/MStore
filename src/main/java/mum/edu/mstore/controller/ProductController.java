package mum.edu.mstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mum.edu.mstore.domain.Album;
import mum.edu.mstore.domain.Product;
import mum.edu.mstore.domain.ProductFile;
import mum.edu.mstore.domain.ProductFile.FileType;
import mum.edu.mstore.service.AlbumService;
import mum.edu.mstore.service.CategoryService;
import mum.edu.mstore.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/secure/admin")
public class ProductController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	AlbumService albumService;

	private final String KEY = "PRODUCT";
	
	
	public ProductController()
	{
		
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("products", productService.findAll());
         System.out.println(productService.findAll());
		return "admin/products";
	}
	
	

	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public String showProduct(Product product, Model model,
			HttpServletRequest request) {

		request.getSession().setAttribute(KEY, product);
		model.addAttribute("categories", categoryService.findAll());
		ProductFile productFile = new ProductFile();
		model.addAttribute("filetypes", productFile.getFileType().values());
		return "admin/addProduct";
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String addProductTest(@ModelAttribute Product product,
			HttpServletRequest request) {

		System.out.println("inside add product post");
		Product myProduct = (Product) request.getSession().getAttribute(KEY);
		// myProduct = product;
		product.setProductFile(myProduct.getProductFile());
		this.productService.add(product);
		return "redirect:/product/products";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request) {

		Product myProduct = (Product) request.getSession().getAttribute(KEY);
		myProduct.setAlbum(this.albumService.findOne(Long.valueOf(request.getParameter("album.id"))));
		myProduct.setCategory(this.categoryService.findOne(Long.valueOf(request.getParameter("category.id"))));
		myProduct.setLength(request.getParameter("length"));
		myProduct.setName(request.getParameter("name"));
		myProduct.setPrice(Double.valueOf(request.getParameter("price")));
		myProduct.setSubCategory(this.categoryService.findSubCategoryBySubCategoryId(Long.valueOf(request.getParameter("subCategory.id"))));
		myProduct.setYear(Long.valueOf(request.getParameter("year")));
		// myProduct = product;
		this.productService.add(myProduct);
		return "redirect:/secure/admin/products";
	}

	@RequestMapping(value = "/album/list", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Album> getSubCategory(
			@RequestParam("subCategoryId") Long id) {

		System.out.println(id);
		System.out.println(albumService
				.findByAlbumSubCategory(this.categoryService
						.findSubCategoryBySubCategoryId(id)));
		return albumService.findByAlbumSubCategory(this.categoryService
				.findSubCategoryBySubCategoryId(id));

	}

	@RequestMapping(value = "/productfile/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Product addProductFile(HttpServletRequest request) {
		Product product = (Product) request.getSession().getAttribute(KEY);
		System.out.println("Nuhendra");
		product.addProductFile(new ProductFile(request.getParameter("name"),
				FileType.valueOf(request.getParameter("type"))));
		request.getSession().setAttribute(KEY, product);
		System.out.println("Product File added: "
				+ request.getParameter("name"));
		return product;
	}

}
