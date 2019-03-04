package learn.standard.java.bean;

public class Father {

    static{
        System.out.println("Father's static");
    }
    public Father(){
        System.out.println("Father's constructor");
    }
    public Father(String name){
        System.out.println("Father's constructor(String)");
    }
}
