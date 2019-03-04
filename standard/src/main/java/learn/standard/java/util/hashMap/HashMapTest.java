package learn.standard.java.util.hashMap;

import learn.standard.java.bean.Sweet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

public class HashMapTest {

    public static void main(String[] args) throws Exception{
        //HashMapTest.ifKeysChanged();
        HashMapTest.forEachTraverseAndDelete();
    }

    public static void ifKeysChanged() throws Exception{
        HashMap<Sweet,String> map = new HashMap<Sweet, String>();
        Sweet sweet = new Sweet("sweet");
        map.put(sweet, sweet.getName());
        sweet.setName("newSweet");
        //当hashcode方法与某些域有关，那么键值的这些域更改以后，就无法再找到这个键值。
        assert !map.containsKey(sweet);

        sweet.setName("sweet");
        assert map.containsKey(sweet);

        Sweet newSweet = new Sweet("sweet");
        assert sweet.equals(newSweet);
        assert map.containsKey(newSweet);
    }

    public static void forEachTraverseAndDelete() throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, 1000).forEach(i -> map.put(i, i));

        Thread traverseThread1 = new Thread(() -> {
            map.entrySet().forEach((entry) -> {
                System.out.println("traverseThread1: " + entry.getKey() + " " + entry.getValue());
                try {
                    Thread.sleep((int)(Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        Thread deleteThread = new Thread(() -> {
            Iterator<Integer> it = map.keySet().iterator();
            int count = 0;
            while(it.hasNext()){
                it.next();
                ++count;
                if (count % 5 == 0)
                    it.remove();
            }
        });

        Thread traverseThread2 = new Thread(() -> {
            map.entrySet().forEach((entry) -> {
                System.out.println("traverseThread2: " + entry.getKey() + " " + entry.getValue());
                try {
                    Thread.sleep((int)(Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        traverseThread1.start();
        deleteThread.start();
        traverseThread2.start();
    }

}
