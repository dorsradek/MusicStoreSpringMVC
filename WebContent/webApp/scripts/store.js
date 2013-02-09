
require(["jquery","store/storeApp"], function($, StoreApp) {
    //the jquery.alpha.js and jquery.beta.js plugins have been loaded.
    $(function() {
    	new StoreApp().init();
    }); 
});
