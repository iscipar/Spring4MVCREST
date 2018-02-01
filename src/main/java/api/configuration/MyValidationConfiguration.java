package api.configuration;

import org.apache.bval.jsr.ApacheValidationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = { "api.controller", "api.domain" })
public class MyValidationConfiguration {

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setProviderClass(ApacheValidationProvider.class);
		return bean;
	}
}