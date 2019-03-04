package factory.abstractfactory;

public abstract class Perfume {
    private final int id;
    public Perfume(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
