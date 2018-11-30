package learn.standard.java.io.serializable;

import java.io.*;

public class SerializableTest implements Serializable {
    private String str1 = "";
    private static String str2 = "str2";
    private transient String str3 = "";

    public SerializableTest(){
        this.str1 = "str1";
        this.str3 = "str3";
    }

    private void writeObject(java.io.ObjectOutputStream s) throws Exception
    {
        s.defaultWriteObject();
        s.writeInt(str3.length());
        for (int i = 0; i < str3.length(); i++)
            s.writeChar(str3.charAt(i));
    }

    private void readObject(java.io.ObjectInputStream s) throws Exception {

        s.defaultReadObject();
        int length = s.readInt();
        char[] cs = new char[length];
        for (int i = 0; i < length; i++)
            cs[i] = s.readChar();
        str3 = new String(cs, 0, length);
    }

    public String toString(){
        return "Str1: " + str1 + ", "
                + "Str2:" + str2 + ", "
                + "Str3:" + str3;
    }

    public static void main(String[] args) throws Exception
    {
        FileOutputStream out = new FileOutputStream(new File("serializableBean.dat"));
        ObjectOutputStream op = new ObjectOutputStream(out);
        op.writeObject(new SerializableTest());
        op.close();

        FileInputStream in = new FileInputStream(new File("serializableBean.dat"));
        ObjectInputStream oi = new ObjectInputStream(in);
        SerializableTest bean = (SerializableTest) oi.readObject();
        oi.close();

        System.out.println(bean.toString());

    }
}
