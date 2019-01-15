package learn.standard.java.bean;

public class Sweet {

    private String name;
    public Sweet(){
        this.name = "sweet";
    }

    public Sweet(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
