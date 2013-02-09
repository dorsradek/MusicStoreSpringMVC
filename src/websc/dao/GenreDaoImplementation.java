	package websc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import websc.models.Album;
import websc.models.Genre;

public class GenreDaoImplementation implements GenreDao {

	DBConnection conn;
	public GenreDaoImplementation(DBConnection dbConnection) {
		this.conn= dbConnection;
	}
	@Override
	public List<Genre> getGenres() {
		return (List<Genre>) conn.getTemplate().query("SELECT * FROM genre",
				new GenreMapper());
	}

	@Override
	public Genre getGenreWithAlbums(String genre) {
		
		GenreMapperWithAlbums mapper= new GenreMapperWithAlbums();
		conn.getTemplate().query(
				"SELECT gen.id id,gen.description description, gen.name, alb.id albumId, alb.title title " +
				"FROM genre gen inner join album alb on gen.id = alb.genre_id " +
				"WHERE gen.name = ?",
				new Object[] { genre },mapper
				);
		return mapper.getGenre();
	}

	public class GenreMapperWithAlbums implements RowMapper<Genre> {
		final Map<Integer,Genre> genres = new HashMap<Integer,Genre>();
		int lastGenre;
		public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
			lastGenre = Integer.parseInt(rs.getString("id"));
			
			Genre genre = genres.get(lastGenre);
			if(genre == null ) {
				genre = new Genre();
				genre.setDescription(rs.getString("description"));
				genre.setId(Integer.parseInt(rs.getString("id")));
				genre.setName(rs.getString("name"));
				genres.put(lastGenre, genre);
			}
			Album album = new Album();
			album.setGenre_id(lastGenre);
			album.setId(Integer.parseInt(rs.getString("albumId")));
			album.setTitle(rs.getString("title"));
			List<Album> temp = genre.getAlbums();
			temp.add(album);
			genre.setAlbums(temp);
			
			genres.put(lastGenre,genre);
			return genre;
		}
		
		public Genre getGenre() {
			return genres.get(lastGenre);
		}
	}
	
	public class GenreMapper implements RowMapper<Genre> {
		
		public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
			Genre genre = new Genre();
			genre.setDescription(rs.getString("description"));
			genre.setId(rs.getInt("id"));
			genre.setName(rs.getString("name"));
		
			return genre;
		}
		
	}
}
