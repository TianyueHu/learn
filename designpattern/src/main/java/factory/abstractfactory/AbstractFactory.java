package factory.abstractfactory;

public interface AbstractFactory {

    public abstract Lipstick lipstick(int id);

    public abstract Perfume perfume(int id);
}
