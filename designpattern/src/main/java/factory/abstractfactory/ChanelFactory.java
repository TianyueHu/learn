package factory.abstractfactory;

public class ChanelFactory implements AbstractFactory{

    public Lipstick lipstick(int id) {
        return new ChanelLipstick(id);
    }

    public Perfume perfume(int id) {
        return new ChanelPerfume(id);
    }
}
