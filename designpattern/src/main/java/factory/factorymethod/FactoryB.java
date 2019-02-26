package factory.factorymethod;

public class FactoryB implements Factory {
    public Product getProduct() {
        return new ProductB();
    }
}
