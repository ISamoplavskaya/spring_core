package hw_spring.autowired;

import org.springframework.stereotype.Component;

@Component("mongoDBRepository")
public class MongoDBRepository implements Repository {
    @Override
    public void save(User user) {
        System.out.println("Saving user in MongoDB database");
    }
}
