define(function() {
	var album = function() {
		var data = {};
		var obj = {};
		var render= function() {
			var main = $('#main').empty();
			var album = $('<p>').text('Album : ' + data.title);
			main.append(album);
		};
		
		obj.init= function(dataObj) {
			data = dataObj;
			render();
		};
		return obj;
	}
	return album;
});