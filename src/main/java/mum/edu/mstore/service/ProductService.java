package mum.edu.mstore.service;

import mum.edu.mstore.domain.Product;

public interface ProductService extends AbstractService<Product, Long>{
	
	public Product findByProductName(String productName);

}
