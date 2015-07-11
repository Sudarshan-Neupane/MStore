package mum.edu.mstore.service;

import mum.edu.mstore.domain.Category;

public interface CategoryService extends AbstractService<Category, Long> {

	public Category findByName(String catName);
}
