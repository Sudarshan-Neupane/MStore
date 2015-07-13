package mum.edu.mstore.repository;

import java.util.List;

import mum.edu.mstore.domain.Product;
import mum.edu.mstore.domain.Rating;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{
	
	public List<Rating> findByProduct(Product product);

}
