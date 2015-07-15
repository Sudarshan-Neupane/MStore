package mum.edu.mstore.repository;

import java.util.List;

import mum.edu.mstore.domain.Category;
import mum.edu.mstore.domain.SubCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public Category findByName(String catName);
	
	public List<SubCategory> findSubCategoryByName(String name);
	
	@Query("SELECT sc from Category c join c.subCategories sc where sc.id=?1")
	public SubCategory findSubCategoryBySubCategoryId(Long id);
}
