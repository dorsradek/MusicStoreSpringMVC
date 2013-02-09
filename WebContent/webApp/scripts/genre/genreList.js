
define(["album/albumList"],function(AlbumList) {
	return function() {
		var data;
		var events = {};
		var obj = {};
		var render = function() {
			var genreList = $('<ul>');
			$('#main').append(genreList);
			$.each(data,function(index,value) {
				var genre= $('<li>').html(value.name);
				genre.click(browseClick(value.name));
				genreList.append(genre);
			});
		}
		
		var browseClick = function(genre) {
			return function(event) {
				trigger('browseGenre',[genre]);
				$.ajax({
					url: '/MusicStoreService/Store/browse/' + genre
				}).done(function(data) {
					var main = new AlbumList().init(data);
				});
			};
		};
		obj.on = function(event,callback) {
			if(events[event]) {
				events[event].push(callback);
			}
			else {
				events[event] = [callback];
			}
		}
		var trigger = function(event,parameters) {
			if(events[event]) {
				$.each(events[event],function(index,callback) {
					callback.apply(null,parameters);
				});
			}
			
		}
		obj.init = function(dataReturned) {
			data = dataReturned;
			render();
		};
		return obj;
	}
	
});

