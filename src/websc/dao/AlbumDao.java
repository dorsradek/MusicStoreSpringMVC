package websc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import websc.models.Album;
import websc.models.Genre;

public interface AlbumDao {

	Album getAlbumDetails(int id);
	
	Boolean save(Album album);
}
