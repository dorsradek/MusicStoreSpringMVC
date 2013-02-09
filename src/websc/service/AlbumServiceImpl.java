package websc.service;

import websc.dao.AlbumDao;
import websc.dao.GenreDao;
import websc.models.Album;

public class AlbumServiceImpl implements AlbumService {

	AlbumDao albumDao;
	public AlbumServiceImpl(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	@Override
	public Album getAlbumDetails(int id) {
		return albumDao.getAlbumDetails(id);
	}
	
	@Override
	public Boolean save(Album album) {
		// TODO Auto-generated method stub
		return albumDao.save(album);
	}

}
