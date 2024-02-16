package hw_spring.autowired;

import org.springframework.stereotype.Component;

@Component("postgresRepository")
public class PostgresRepository implements Repository {
    @Override
    public void save(User user) {
        System.out.println("Saving user in Postgres database");

    }
}
