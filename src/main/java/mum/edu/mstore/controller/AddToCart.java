/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.mstore.controller;

import mum.edu.mstore.domain.Product;
import mum.edu.mstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddToCart {
    @Autowired
	private CategoryService categoryService;
    @RequestMapping(value = "/secure/addtocart", method = RequestMethod.GET)
    public String addItem(Model model,Product product){
    model.addAttribute("categories", categoryService.findAll());
        return "addtocart";
    }
    
    
}
