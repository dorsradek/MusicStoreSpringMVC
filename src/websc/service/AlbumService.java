package websc.service;

import websc.models.Album;

public interface AlbumService {

	Album getAlbumDetails(int id);
	
	Boolean save(Album album);
}
