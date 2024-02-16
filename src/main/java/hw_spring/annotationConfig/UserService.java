package hw_spring.annotationConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Value("${property.name}")
    private String username;

    public String getUsername() {
        return username;
    }
}
