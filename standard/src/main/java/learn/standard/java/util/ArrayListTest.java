package java.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    List<Integer> arrayList = new ArrayList<Integer>();

    public ArrayListTest(){
        for(int i = 0; i < 100; ++i){
            arrayList.add(i);
        }
    }

    public void iteratorTest(){
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            iterator.remove();
        }

    }

    public static void main(String[] args){
        //System.out.println(String[].class);
    }



}
