package factory.abstractfactory;

public abstract class Lipstick {
    private final int id;

    protected Lipstick(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
