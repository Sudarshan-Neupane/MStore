package mum.edu.mstore.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.mstore.domain.Album;
import mum.edu.mstore.repository.AlbumRepository;
import mum.edu.mstore.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumRepository albumRepository;
	
	@Override
	@Transactional
	public void add(Album t) {
		if(this.albumRepository.findByName(t.getName()) != null){
			throw new IllegalArgumentException("Invalid album");
		}
		this.albumRepository.save(t);
	}

	@Override
	@Transactional
	public void update(Album t) {
		if(this.albumRepository.findOne(t.getId()) == null){
			throw new IllegalArgumentException("Invalid album");
		}
		this.albumRepository.save(t);
	}

	@Override
	public Album findOne(Long obj) {
		if(obj == null){
			throw new IllegalArgumentException("Invalid album id");
		}
		return this.albumRepository.findOne(obj);
	}

	@Override
	public List<Album> findAll() {
		return this.albumRepository.findAll();
	}

}
