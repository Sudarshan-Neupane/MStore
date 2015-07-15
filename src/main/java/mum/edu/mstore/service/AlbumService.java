package mum.edu.mstore.service;

import java.util.List;

import mum.edu.mstore.domain.Album;
import mum.edu.mstore.domain.SubCategory;

public interface AlbumService extends AbstractService<Album, Long>{
	/***
	 * 
	 * @param id
	 */
	
	public Album findByName(String albumName);
	
	public void deleteAlbum(Long id);
	
	public List<Album> findByAlbumSubCategory(SubCategory subCategory);
}
