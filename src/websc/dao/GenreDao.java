package websc.dao;

import java.util.List;

import websc.models.Genre;

public interface GenreDao {
	
	List<Genre> getGenres();

	Genre getGenreWithAlbums(String genre);

}
