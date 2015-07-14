package mum.edu.mstore.controller;

import javax.servlet.http.HttpServletRequest;

import mum.edu.mstore.domain.Category;
import mum.edu.mstore.domain.SubCategory;
import mum.edu.mstore.service.CategoryService;
import mum.edu.mstore.utils.SpringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author bipin
 */
@Controller
@RequestMapping("/secure/admin")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	private final String KEY = "CATEGORY";

	public CategoryController() {
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("categories", categoryService.findAll());

		return "admin/categories";
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public String addCategory(HttpServletRequest request) {
		request.getSession().setAttribute(KEY, new Category());
		System.out.println("username from sessoin: "
				+ SpringUtils.getUserName());
		return "admin/addcategory";
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String onSaveCategory(HttpServletRequest request) {
		System.out.println("inside: category add " + SpringUtils.getUserName());
		Category category = (Category) request.getSession().getAttribute(KEY);
		category.setName(request.getParameter("name"));
		this.categoryService.add(category);
		return "redirect:/secure/admin/categories";
	}

	@RequestMapping(value = "/category/delete", method = RequestMethod.GET)
	public String onDeleteCategory(@RequestParam("id") String id) {
		System.out.println("inside delete category category_id " + id);
		this.categoryService.deleteCategory(Long.valueOf(id));
		
		return "redirect:/secure/admin/categories";
	}

	@RequestMapping(value = "/subcategory/delete", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Category getSubCategory(
			@RequestParam("name") String name, HttpServletRequest request) {
		Category category = (Category) request.getSession().getAttribute(KEY);
		category.removeSubCategory(new SubCategory(name));
		request.getSession().setAttribute(KEY, category);
		System.out.println("sub category added: " + name
				+ SpringUtils.getUserName());
		return category;
	}

	@RequestMapping(value = "/subcategory/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Category subCategory(HttpServletRequest request) {
		Category category = (Category) request.getSession().getAttribute(KEY);
		category.addSubCategory(new SubCategory(request.getParameter("name")));
		request.getSession().setAttribute(KEY, category);
		System.out.println("sub category added: "
				+ request.getParameter("name"));
		return category;
	}

	// @RequestMapping(value = "/subcategory/add", method = RequestMethod.POST)
	// public @ResponseBody
	// String hello() {
	// System.out.println("Post method called");
	// return "hello";
	// }
}
