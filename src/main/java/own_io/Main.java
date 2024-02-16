package own_io;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext("own_io");
        Car car = context.getBean(Car.class);
        car.start();
    }
}
