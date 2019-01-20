package reflection;

public class Person{
    private String name;
    private int age;
    private String gender;

    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    public Person(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public String toString(){
        return "My name is " + name + " and I'm " + age + " years old.";
    }
}
