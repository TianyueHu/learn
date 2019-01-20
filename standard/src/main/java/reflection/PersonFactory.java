package reflection;

public class PersonFactory {

    public static Person createPersonInfo(String name) throws Exception{
        try {
            Class pClass = Class.forName(name);
            return (Person)pClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public static void main(String[] args) throws Exception {
        Person student = PersonFactory.createPersonInfo("reflection.Student");
        Person professor = PersonFactory.createPersonInfo("reflection.Professor");

        System.out.println(student.getClass().toString());
        System.out.println(professor.getClass().toString());
    }
}
