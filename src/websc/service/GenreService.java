package websc.service;

import java.util.List;

import websc.models.Genre;

public interface GenreService {

	List<Genre> getGenres();

	Genre getGenreWithAlbums(String genre);
}
