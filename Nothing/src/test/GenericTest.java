package test;

import org.junit.Test;

import java.util.*;

/**
 @author：ZhouYao
 @create：2021-10-15 19:50
 */
public class GenericTest {


    @Test
    public void test1() {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(24);
        list.add(36);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("miao", 11);

        Set<Map.Entry<String, Integer>> entry = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "-----" + value);
        }


    }


}
