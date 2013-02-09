package websc.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public interface DaoConfiguration {

	@Bean
	GenreDao getGenreDao();

	@Bean
	AlbumDao getAlbumDao();

}
