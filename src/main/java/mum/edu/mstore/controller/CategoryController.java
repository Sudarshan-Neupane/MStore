package mum.edu.mstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mum.edu.mstore.domain.Category;
import mum.edu.mstore.domain.SubCategory;
import mum.edu.mstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
        return "admin/addcategory";
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String onSaveCategory() {
    	System.out.println("fuck");
//        Category category = (Category) request.getSession().getAttribute(KEY);
//        category.setName(request.getParameter("name"));
//        this.categoryService.add(category);
        return "redirect:/home";
    }

    @RequestMapping(value = "/subcategory/add", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Category getSubCategory(@RequestParam("name") String name, HttpServletRequest request) {
        Category category = (Category) request.getSession().getAttribute(KEY);
        category.addSubCategory(new SubCategory(name));
        request.getSession().setAttribute(KEY, category);
        System.out.println("sub category added: " + name);
        return category;
    }

    @RequestMapping(value = "/subcategory/add", produces = "application/json", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Category subCategory(@RequestBody SubCategory subCategory, HttpServletRequest request) {
        Category category = (Category) request.getSession().getAttribute(KEY);
        category.addSubCategory(subCategory);
        request.getSession().setAttribute(KEY, category);
        System.out.println("sub category added: " + subCategory.getName());
        return category;
    }

//    @RequestMapping(value = "/subcategory/add", method = RequestMethod.POST)
//    public @ResponseBody
//    String hello() {
//        System.out.println("Post method called");
//        return "hello";
//    }
}
