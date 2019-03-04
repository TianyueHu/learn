package factory.abstractfactory;

public class DiorFactory implements AbstractFactory{


    public Lipstick lipstick(int id) {
        return new DiorLipstick(id);
    }

    public Perfume perfume(int id) {
        return new DiorPerfume(id);
    }
}
