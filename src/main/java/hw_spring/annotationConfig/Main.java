package hw_spring.annotationConfig;

import hw_spring.annotationConfig.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        EmailService emailService = context.getBean(EmailService.class);
        emailService.sendEmail("alex@gmail.com");

    }
}
