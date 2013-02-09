define(['album/album','album/albumList', 'genre/genreList'], function(Album, AlbumList,GenreList) {

	var storeApp = function() {
		var obj = {};

		obj.listGenres = function() {
			$.ajax({
	    		url: '/MusicStoreService/Store'
	    	}).done(function(data) {
	    		var genreList = new GenreList();
	    		genreList.on('browseGenre',obj.showGenre);
	    		genreList.init(data);
	    	});
		}

		obj.showGenre =function(genre) {
			$.ajax({
				url: '/MusicStoreService/Store/browse/' + genre
			}).done(function(data) {
				var main = new AlbumList().init(data);
			});
		}
		obj.init = function() {
			obj.listGenres();
		}
		return obj;
	}
	return storeApp;
});