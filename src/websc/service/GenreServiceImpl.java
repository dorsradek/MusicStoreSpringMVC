package websc.service;

import java.util.List;

import websc.dao.GenreDao;
import websc.models.Genre;

public class GenreServiceImpl implements GenreService {

	GenreDao genreDao;
	public GenreServiceImpl(GenreDao genreDao) {
		this.genreDao = genreDao;
	}
	@Override
	public List<Genre> getGenres() {
		return genreDao.getGenres();
	}
	@Override
	public Genre getGenreWithAlbums(String genre) {
		return genreDao.getGenreWithAlbums(genre);
	}

}
