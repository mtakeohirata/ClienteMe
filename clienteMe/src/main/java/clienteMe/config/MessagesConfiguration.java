package clienteMe.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MessagesConfiguration {

	@Bean
	public ReloadableResourceBundleMessageSource getMessageBundle() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		por padrao o setBasename ja concatena com ".properties...o classpath indicada o diretorio
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("ISO-8859-1");
		messageSource.setDefaultLocale(Locale.getDefault());
		return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidatorFactory() {
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setValidationMessageSource(getMessageBundle());
		
		return factoryBean;
	}
	
	
	
}
