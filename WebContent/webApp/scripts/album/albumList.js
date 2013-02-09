define(["album/album"],function(Album) {
	var albumList= function() {
		var data = {};
		var obj = {};
		var albumClick = function(id) {
			return function(event) {
				$.ajax({
					url: '/MusicStoreService/Store/details/' + id
				}).done(function(data) {
					var main = new Album().init(data);
				});
			};
		};
		
		var render = function() {
			var main = $('#main').empty();
			var title= $('<div>').html(data.name);
			var albums = $('<table>').addClass("table table-bordered").append("<thead><tr><th>Album Title</th></tr></thead>");
			
			main.append(title);
			main.append(albums);
			var albumBody = $('<tbody>');
			albums.append(albumBody);
			$.each(data.albums, function(index,value) {
				var album = $('<tr>');
				album.append($('<td>').html(value.title));
				album.click(albumClick(value.id));
				albumBody.append(album);
			});
		};
		
		obj.init = function(dataObj) {
			data= dataObj;
			render();
		};
		
		return obj;
	}
	return albumList;
});