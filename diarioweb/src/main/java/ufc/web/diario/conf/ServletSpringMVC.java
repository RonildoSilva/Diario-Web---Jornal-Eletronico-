package ufc.web.diario.conf;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends
AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{
				AppWebConfiguration.class,
				JPAConfiguration.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	/** Gambi**/
	
	@Override
	protected javax.servlet.Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

		encodingFilter.setForceEncoding(true);
		encodingFilter.setEncoding("UTF-8");

		// encoding filter must be the first one
		return (javax.servlet.Filter[]) new Filter[]{(Filter) encodingFilter,
				(Filter) new DelegatingFilterProxy("springSecurityFilterChain"),
				(Filter) new OpenEntityManagerInViewFilter()};
		//return super.getServletFilters();
	}

}
