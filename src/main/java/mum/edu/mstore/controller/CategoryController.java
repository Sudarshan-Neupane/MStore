package mum.edu.mstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mum.edu.mstore.domain.Category;
import mum.edu.mstore.domain.SubCategory;
import mum.edu.mstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String addCategory(@ModelAttribute Category category, HttpServletRequest request) {
        request.getSession().setAttribute(KEY, category);
        return "admin/addCategory";
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String onSaveCategory(HttpServletRequest request, HttpServletResponse response) {
        Category category = (Category) request.getSession().getAttribute(KEY);
        category.setName(request.getParameter("name"));
        this.categoryService.add(category);
        return "admin/home";
    }

    @RequestMapping(value = "/subcategory/add", method = RequestMethod.GET)
    public void getSubCategory(Model model) {
        model.addAttribute("subcat", new SubCategory());
    }

    @RequestMapping(value = "/subcategory/add", method = RequestMethod.POST)
    public void setSubCategory(@ModelAttribute SubCategory subcat, HttpServletRequest request) {
        Category category = (Category) request.getSession().getAttribute(KEY);
        category.addSubCategory(subcat);
    }
}
