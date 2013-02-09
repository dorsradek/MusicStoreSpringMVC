package websc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import websc.dao.DaoConfiguration;


@Configuration
public interface ServiceConfiguration {

	@Bean
	GenreService getGenreService();
	
	@Bean
	AlbumService getAlbumService();
}
