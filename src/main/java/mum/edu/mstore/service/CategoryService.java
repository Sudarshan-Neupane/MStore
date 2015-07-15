package mum.edu.mstore.service;

import mum.edu.mstore.domain.Category;
import mum.edu.mstore.domain.SubCategory;

public interface CategoryService extends AbstractService<Category, Long> {

	public Category findByName(String catName);

	public void deleteCategory(Long id);
	
	public SubCategory findSubCategoryBySubCategoryId(Long id);
}
