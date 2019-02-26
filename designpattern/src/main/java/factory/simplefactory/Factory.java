package factory.simplefactory;

public class Factory {

    public static Product getProduct(String type){
        if(type.equals("A")){
            return new ConcreteProductA();
        }
        else if(type.equals("B")){
            return new ConcreteProductB();
        }
        else{
            throw new NoThisKindProductException();
        }
    }
}
