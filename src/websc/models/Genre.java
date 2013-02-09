package websc.models;

import java.util.ArrayList;
import java.util.List;

public class Genre {

	private int id;
	private String name;
	private String description;
	private List<Album> albums = new ArrayList<Album>();
	
	public Genre() {
		
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}	
}
