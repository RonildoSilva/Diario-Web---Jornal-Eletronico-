package ufc.web.diario.conf;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ufc.web.diario.controller.HomeController;
import ufc.web.diario.dao.ComentarioDAO;
import ufc.web.diario.dao.NoticiaDAO;
import ufc.web.diario.dao.SecaoDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses = 
{
		HomeController.class,
		NoticiaDAO.class,
		ComentarioDAO.class,
		SecaoDAO.class
})
public class AppWebConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public InternalResourceViewResolver	internalResourceViewResolver() {
		InternalResourceViewResolver resolver =	new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }	
	
}

