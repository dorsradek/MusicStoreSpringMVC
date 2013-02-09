package websc.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import websc.dao.DefaultDaoConfiguration;
import websc.service.DefaultServiceConfiguration;


@EnableWebMvc
@Configuration
@Import({ ControllerConfiguration.class, DefaultServiceConfiguration.class, DefaultDaoConfiguration.class })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public Validator getValidator() {
		return new LocalValidatorFactoryBean();
	}

	@Bean
	public ViewResolver getViewResolver() {
	
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

//	private static final Class<?>[]	JAXB_CLASSES_TO_BE_BOUND	= { Profile.class, Setting.class };
//
//	@Bean
//	public RequestMappingHandlerAdapter getHandlerAdapter() {
//		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
//		converters.add(new StringHttpMessageConverter());
//
//		Jaxb2Marshaller m = new Jaxb2Marshaller();
//		m.setClassesToBeBound(JAXB_CLASSES_TO_BE_BOUND);
//
//		MarshallingHttpMessageConverter converter = new MarshallingHttpMessageConverter();
//
//		converter.setMarshaller(m);
//		converter.setUnmarshaller(m);
//
//		converters.add(converter);
//		converters.add(new MappingJacksonHttpMessageConverter());
//
//		RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
//
//		adapter.setMessageConverters(converters);
//		return adapter;
//	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("home");
//	}
}
