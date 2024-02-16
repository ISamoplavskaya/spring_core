package hw_spring.classPathXml;

import lombok.Data;

@Data
public class Product {
    private String name;
    private int price;

    public void init() {
        System.out.println("I initialize");
    }

    @BuyLog
    public void buy() {
        System.out.println("buying...");
    }
}
