package mum.edu.mstore.serviceimpl;

import java.util.List;

import mum.edu.mstore.domain.Product;
import mum.edu.mstore.domain.Rating;
import mum.edu.mstore.repository.RatingRepository;
import mum.edu.mstore.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RatingServiceImpl implements RatingService  {
	
	@Autowired
	RatingRepository ratingRepository;


	@Override
	public void add(Rating t) {
		// TODO Auto-generated method stub
		
		this.ratingRepository.save(t);
		
	}

	@Override
	public void update(Rating t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rating findOne(Long obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> findByProduct(Product product) {
		
		return this.ratingRepository.findByProduct(product);
	}

}
