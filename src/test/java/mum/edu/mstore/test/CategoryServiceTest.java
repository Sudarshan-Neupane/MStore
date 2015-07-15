package mum.edu.mstore.test;

import mum.edu.mstore.domain.Category;
import mum.edu.mstore.domain.SubCategory;
import mum.edu.mstore.service.CategoryService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({AlbumServiceTest.class})
public class CategoryServiceTest extends BaseTest {

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
		Assert.assertEquals(2, c.getSubCategories().size());
		SubCategory subCat = c.getSubCategories().get(0);
		System.out.println("subCat Name: " + subCat.getName());
		SubCategory sc = this.categoryService
				.findSubCategoryBySubCategoryId(subCat.getId());
		Assert.assertEquals(subCat.getName(), sc.getName());

	}
}
