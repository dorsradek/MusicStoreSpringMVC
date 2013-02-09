package websc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import websc.models.Album;
import websc.models.Genre;
import websc.service.ServiceConfiguration;



@Controller
@SessionAttributes("storeManager")
@RequestMapping("/StoreManager")
public class StoreManagerController {
	
	ServiceConfiguration servConfig;
	public StoreManagerController(ServiceConfiguration serviceConfiguration) {
		this.servConfig = serviceConfiguration;
	}
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Boolean save() {
		
		return false;
	}
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Boolean save(@RequestBody Album album) {
		servConfig.getAlbumService().save((Album) album);
		return false;
	}

}
