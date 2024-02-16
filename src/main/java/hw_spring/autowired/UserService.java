package hw_spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    private final Repository repository;

    @Autowired
    public UserService(@Qualifier("mongoDBRepository") Repository repository) {
        this.repository = repository;
    }

    public void save(User user) {
        repository.save(user);
    }
}