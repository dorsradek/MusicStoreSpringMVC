package websc.controllers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import websc.controllers.StoreController;
import websc.controllers.StoreManagerController;
import websc.service.ServiceConfiguration;

@Configuration
public class ControllerConfiguration {

	// Auto Wire ServiceConfig so we can get the Service objects
	@Autowired
	private ServiceConfiguration	serviceConfiguration;

	@Bean
	public StoreController getStoreController() {
		return new StoreController(serviceConfiguration);
	}
	
	@Bean
	public StoreManagerController getStoreManagerController() {
		return new StoreManagerController(serviceConfiguration);
	}
}
