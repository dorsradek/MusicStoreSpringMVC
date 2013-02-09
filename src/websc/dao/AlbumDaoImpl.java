package websc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import websc.dao.GenreDaoImplementation.GenreMapper;
import websc.models.Album;
import websc.models.Genre;

public class AlbumDaoImpl implements AlbumDao {

	private DBConnection dbconn;
	public AlbumDaoImpl(DBConnection dbconn) {
		this.dbconn = dbconn;
	}
	@Override
	public Album getAlbumDetails(int id) {
		return (Album) dbconn.getTemplate().queryForObject(
				"SELECT * " +
				"FROM album inner join genre on album.genre_id=genre.id " +
				"where album.id= ?", 
				new Object[] { id }, new AlbumMapper());
	}
	

	@Override
	public Boolean save(Album album) {
		if (album.isNew()) {
			String sql = "UPDATE album " +
					"Set title = ?, genre_id = ? " +
					"Where id = ?";
			try {
				int rowsUpdated=dbconn.getTemplate().update(sql, new Object[] { album.getTitle(), album.getGenre_id()});
				if (rowsUpdated > 0) {
					return true;
				}
				else {
					return false;
				}
			}
			catch(DataAccessException daExc) {
				return false;
			}
		}
		else {
			String sql = "INSERT INTO album " +
					"(title,genre_id) VALUES (?, ?)";
			try {
				int rowsUpdated=dbconn.getTemplate().update(sql, new Object[] { album.getTitle(), album.getGenre_id()});
				if (rowsUpdated > 0) {
					return true;
				}
				else {
					return false;
				}
			}
			catch(DataAccessException daExc) {
				return false;
			}
		}
	}
	
	public class AlbumMapper implements RowMapper<Album> {
		public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
			Album album = new Album();
			
			album.setId(Integer.parseInt(rs.getString("id")));
			album.setTitle(rs.getString("title"));
			
			Genre genre = new Genre();
			genre.setDescription(rs.getString("description"));
			genre.setId(rs.getInt("genre_id"));
			genre.setName(rs.getString("name"));
			album.setGenre(genre);
			return album;
		}
	}



}
