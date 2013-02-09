package websc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import websc.dao.DaoConfiguration;


@Configuration
public class DefaultServiceConfiguration implements ServiceConfiguration {

	@Autowired
	private DaoConfiguration	daoConfiguration;

	@Override
	@Bean
	public GenreService getGenreService() {
		return new GenreServiceImpl(daoConfiguration.getGenreDao());
	}

	@Override
	@Bean
	public AlbumService getAlbumService() {
		return new AlbumServiceImpl(daoConfiguration.getAlbumDao());
	}

	
	
}
