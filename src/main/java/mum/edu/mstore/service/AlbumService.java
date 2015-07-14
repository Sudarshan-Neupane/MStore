package mum.edu.mstore.service;

import mum.edu.mstore.domain.Album;

public interface AlbumService extends AbstractService<Album, Long>{
	/***
	 * 
	 * @param id
	 */
	public void deleteAlbum(Long id);
}
