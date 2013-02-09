require(["jquery","album/albumList"], function($, AlbumList) {
    //the jquery.alpha.js and jquery.beta.js plugins have been loaded.
    $(function() {
    	$.ajax({
			url: '/MusicStoreService/Store/browse/Rock'
		}).done(function(data) {
			var main = new AlbumList().init(data);
		});
    });
});
