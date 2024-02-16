package own_io;

@Component
public class Car {
    @Autowired
    private Engine engine;

    public void start() {
        engine.start();
        System.out.println("Car started");
    }
}