package mum.edu.mstore.serviceimpl;

import java.util.List;

import mum.edu.mstore.domain.Product;
import mum.edu.mstore.repository.ProductRepository;
import mum.edu.mstore.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	ProductRepository productRepository;
	

	@Transactional
	@Override
	public void add(Product t) {
	   Product product = this.productRepository.findByName(t.getName());
	   if (product != null) {
			throw new IllegalArgumentException("User already exist.");
		}
	   
		this.productRepository.save(t);
		
	}

	@Override
	public void update(Product t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findOne(Long obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findByProductName(String productName) {
		// TODO Auto-generated method stub
		if(productName.isEmpty()){
			throw new IllegalArgumentException("Invalid category name");
		}
		return this.productRepository.findByName(productName);
	}

}
