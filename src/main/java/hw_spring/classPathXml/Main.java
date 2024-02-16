package hw_spring.classPathXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Product product1 = context.getBean("product1", Product.class);
        Product product2 = context.getBean("product2", Product.class);
        product1.buy();
        System.out.println(product1);
        System.out.println(product2);

    }
}
