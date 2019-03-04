package learn.standard.java.bean;

public class Sweet {

    private String name;
    public Sweet(String name){
        this.name = name;
    }
    public Sweet(){
        this("sweet");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object){
//        if(object == this)
//            return true;
        if(object instanceof Sweet){
            if(((Sweet) object).getName().equals(name))
                return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        int hash = 0;
        if(name != null){
            for(int i = 0; i < name.length(); ++i){
                hash += name.charAt(i);
            }
        }
        return hash;
    }

}
