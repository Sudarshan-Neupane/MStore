package mum.edu.mstore.test;

import mum.edu.mstore.domain.Category;
import mum.edu.mstore.domain.SubCategory;
import mum.edu.mstore.service.CategoryService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryTest extends BaseTest{

	@Autowired
	private CategoryService categoryService;

	private static final String CAT_NAME = "Solo Music";
	private static final String SUB_CAT_NAME_1 = "Fast Track";
	private static final String SUB_CAT_NAME_2 = "Slow Track";

	@Test
	public void addTest() {
		Category category = new Category(CAT_NAME);
		category.addSubCategory(new SubCategory(SUB_CAT_NAME_1));
		category.addSubCategory(new SubCategory(SUB_CAT_NAME_2));
		this.categoryService.add(category);
		Category c = this.categoryService.findByName(CAT_NAME);
		System.out.println(c.getName());
		Assert.assertEquals(c.getSubCategories().size(), 2);
	}
}
