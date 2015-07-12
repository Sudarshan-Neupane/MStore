package mum.edu.mstore.repository;

import mum.edu.mstore.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public Product findByName(String productName);

}
