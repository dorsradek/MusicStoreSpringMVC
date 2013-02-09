package websc.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ChangeSQLFirstStep {
	public static void main(String args[])
	{
		File originalAlbumFile = new File("C:/Users/ARAMOS/Documents/Showcase/MusicStoreService/src/websc/utils/albumBootsrap.file");
		List<AlbumOriginal> albums = getAlbums(originalAlbumFile);

		File firstStepAlbum = new File("C:/Users/ARAMOS/Documents/Showcase/MusicStoreService/src/websc/utils/albumBootsrapFirstStep.file");
		
	    try {
			setFirstStepAlbum(firstStepAlbum, albums);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static public void setFirstStepAlbum(File aFile,List<AlbumOriginal> albums)
            throws FileNotFoundException, IOException {
		if (aFile == null) {
			throw new IllegalArgumentException("File should not be null.");
		}
		if (!aFile.exists()) {
			aFile.createNewFile();
		}
		if (!aFile.isFile()) {
			throw new IllegalArgumentException("Should not be a directory: " + aFile);
		}
		if (!aFile.canWrite()) {
			throw new IllegalArgumentException("File cannot be written: " + aFile);
		}

		//use buffering
		String content = "INSERT INTO ALBUM (genre_id, title) VALUES \n";
		Writer output = new BufferedWriter(new FileWriter(aFile));
		try {
			
			for(AlbumOriginal album : albums) {
				content += album.toStringFirstStep() + ",\n";
			}
			content = content.substring(0, content.length()-2);
			output.write(content);
		}
		finally {
			output.close();
		}
	}
	static public List<AlbumOriginal> getAlbums(File aFile) {
		//...checks on aFile are elided
		List<AlbumOriginal> albums = new ArrayList<AlbumOriginal>();

		try {
			//use buffering, reading one line at a time
			//FileReader always assumes default encoding is OK!
			BufferedReader input =  new BufferedReader(new FileReader(aFile));
			try {
				String line = null; //not declared within while loop
				/*
				* readLine is a bit quirky :
				* it returns the content of a line MINUS the newline.
				* it returns null only for the END of the stream.
				* it returns an empty String if two newlines appear in a row.
				*/
				while (( line = input.readLine()) != null){
					AlbumOriginal album = new AlbumOriginal(line) ;
					albums.add(album);
				}
			}
			finally {
				input.close();
			}
		}
		catch (IOException ex){
		  ex.printStackTrace();
		}

		return albums;
	}

}
