package websc.utils;

public class AlbumOriginal {

	
	private String title;
	private double price;
	private int id;
	private int artistId;
	private int genreId;
	private String url;
	
	public AlbumOriginal(String line) {
		line = line.substring(98);
		String[] fields = line.split(",");
		System.out.println(fields);
		this.setId(fields[0]);
		this.setGenreId(fields[1]);
		this.setArtistId(fields[2]);
		this.setTitle(fields[3]);
		this.setPrice(fields[4]);
		this.setUrl(fields[6]);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		int hiffen = title.indexOf("'");
		title = title.substring(hiffen+1);
		hiffen = title.indexOf("'");
		if(hiffen <0 ) 
		{
			System.out.println("OLA");
		}
		title = title.substring(0,hiffen);
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(String priceString) {
		int bracketStart = priceString.indexOf('(');
		priceString = priceString.substring(bracketStart+1);
		int space = priceString.indexOf(" ");
		priceString = priceString.substring(0,space);
		this.price = Double.parseDouble(priceString);
	}

	public int getId() {
		return id;
	}

	public void setId(String idString) {
		this.id = Integer.parseInt(idString);
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistString) {
		artistString = artistString.replace(" ", "");
		this.artistId = Integer.parseInt(artistString);
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreString) {

		genreString = genreString.replace(" ", "");
		this.genreId = Integer.parseInt(genreString);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		int hiffen = url.indexOf("'");
		url = url.substring(hiffen+1);
		hiffen = url.indexOf("'");
		if(hiffen < 0) {
			System.out.println("OLA");
		}
		url = url.substring(0,hiffen);
		this.url = url;
	}

	public String toStringFirstStep() {
		return "(" + (this.genreId+99) +",'" + this.title + "')";
	}
}
