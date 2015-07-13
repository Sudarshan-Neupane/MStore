package mum.edu.mstore.service;

import java.util.List;

import mum.edu.mstore.domain.Product;
import mum.edu.mstore.domain.Rating;

public interface RatingService extends AbstractService<Rating, Long> {
	
	public List<Rating> findByProduct(Product product);
	

}
