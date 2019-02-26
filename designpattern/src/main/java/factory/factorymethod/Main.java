package factory.factorymethod;

public class Main {

    public static void main(String[] args){
        //假设从配置文件里面得到
        String factoryName = "factory.factorymethod.FactoryA";

        Factory factory = getFactory(factoryName);
        Product product = factory.getProduct();

        product.printName();

    }

    public static Factory getFactory(String factoryName){
        Object o = null;
        try {
            Class cls = Class.forName(factoryName);
            o = cls.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return (Factory)o;
    }
}
