package hw_spring.classPathXml;

public class SuperProxyProduct extends Product {
    private final Product product;

    public SuperProxyProduct(Product bean) {
        super.setName(bean.getName());
        super.setPrice(bean.getPrice());
        product = bean;
    }

    @Override
    public void buy() {
        System.out.println("notifying some system about this product");
        product.buy();
    }
}
