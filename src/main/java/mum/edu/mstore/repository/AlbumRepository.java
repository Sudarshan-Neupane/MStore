package mum.edu.mstore.repository;

import java.util.List;

import mum.edu.mstore.domain.Album;
import mum.edu.mstore.domain.SubCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

	/***
	 * 
	 * @param name
	 * @return album object
	 */
	public Album findByName(String name);
	
	/***
	 * 
	 * @param subCategory
	 * @return
	 */
	public List<Album> findBySubCategory(SubCategory subCategory);
}
