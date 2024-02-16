package hw_spring.annotationConfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "hw_spring")
@PropertySource("classpath:/application.properties")
public class ApplicationConfig {

}
