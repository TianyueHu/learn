package singleton;

public class Singleton_1 {


    private Singleton_1(){

    }
    private static class InnerClass{
        private static Singleton_1 singleton_1 = new Singleton_1();
    }
    public static Singleton_1 getInstance(){
        return InnerClass.singleton_1;
    }
}
