package mum.edu.mstore.serviceimpl;

import java.util.List;

import mum.edu.mstore.domain.Category;
import mum.edu.mstore.repository.CategoryRepository;
import mum.edu.mstore.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	@Override
	public void add(Category t) {
		if(this.categoryRepository.findByName(t.getName()) != null){
			throw new IllegalArgumentException("Invalid category name.");
		}
		this.categoryRepository.save(t);
	}

	@Transactional
	@Override
	public void update(Category t) {
		if(this.categoryRepository.findOne(t.getId()) == null){
			throw new IllegalArgumentException("Invalid category");
		}
		this.categoryRepository.save(t);
		
	}

	@Override
	public Category findOne(Long obj) {
		if(obj == null){
			throw new IllegalArgumentException("Invalid category id");
		}
		return this.categoryRepository.findOne(obj);
	}

	@Override
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Category findByName(String catName) {
		if(catName.isEmpty()){
			throw new IllegalArgumentException("Invalid category name");
		}
		return this.categoryRepository.findByName(catName);
	}

}
