package hw_spring.annotationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    @Autowired
    private UserService userService;

    public void sendEmail(String to) {
        System.out.println("Email sent to " + to + " with message: Hello, " + userService.getUsername());
    }
}
