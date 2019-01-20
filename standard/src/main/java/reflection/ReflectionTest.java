package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    public static void getClassInstance(){
        // 1
        try {
            Class c1 = Class.forName("java.lang.Integer");
            System.out.println(c1.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 2
        Class c2 = Integer.class;
        System.out.println(c2.getName());
        // 3
        Integer i1 = 1;
        Class c3 = i1.getClass();
        System.out.println(c3.getName());
        System.out.println();
    }

    public static void callMethod(){
        try {
            Class pClass = Class.forName("reflection.Person");
            Constructor<?> constructor = pClass.getConstructor(String.class);
            Object person = constructor.newInstance("Lucy");

            Method setAge = pClass.getMethod("setAge", int.class);
            setAge.invoke(person, 25);
            Method toString = pClass.getMethod("toString");
            System.out.println(toString.invoke(person));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setField(){
        try {
            Class pClass = Class.forName("reflection.Person");

            Constructor constructor = pClass.getConstructor(String.class);
            Object person = constructor.newInstance("Lucy");
            Field field = pClass.getDeclaredField("age");
            field.setAccessible(true);
            field.set(person, 25);

            Method toString = pClass.getMethod("toString");
            System.out.println(toString.invoke(person));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        ReflectionTest.getClassInstance();
        ReflectionTest.callMethod();
        ReflectionTest.setField();
    }



}
