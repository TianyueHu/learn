package learn.standard.java.bean;

public class Son extends Father {

    static{
        System.out.println("Son's static");
    }

    public Son(){
        System.out.println("Son's constructor");
    }

    public Son(String name){
        System.out.println("Son's constructor(String)");
    }

    public static void main(String[] args){
        //new Son();
        new Son("Jack");
    }
}
