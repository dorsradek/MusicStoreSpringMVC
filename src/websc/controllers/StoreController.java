package websc.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import websc.models.Album;
import websc.models.Genre;
import websc.service.ServiceConfiguration;


@Controller
@SessionAttributes("store")
@RequestMapping("/Store")
public class StoreController {

	ServiceConfiguration servConfig;
	public StoreController(ServiceConfiguration serviceConfiguration) {
		this.servConfig = serviceConfiguration;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Genre> getGenres() {
		List<Genre> genres = servConfig.getGenreService().getGenres();
		return genres;
	}
	
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public @ResponseBody Album getAlbumDetails(@PathVariable int id) {
		return servConfig.getAlbumService().getAlbumDetails(id);
	}
	
	@RequestMapping(value = "/browse/{genreName}", method = RequestMethod.GET)
	public @ResponseBody Genre getGenreWithAlbums(@PathVariable String genreName) {
		Genre genre = servConfig.getGenreService().getGenreWithAlbums(genreName);
		return genre;
	}
}
