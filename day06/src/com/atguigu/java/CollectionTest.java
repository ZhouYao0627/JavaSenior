package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试  --->前五个方法在day05的java2中
 *
 * 结论：
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()方法
 *
 * @author：ZhouYao
 * @create：2021-07-14 22:07
 */
public class CollectionTest {
     /*
     1.add(Object e)：将元素e添加到集合coll中  --->若e为数字等元素，则会自动装箱
     2.size()：获取添加的元素的个数
     3.addAll(Collection coll1)：将coll1集合中的元素添加到当前的集合中
     4.clear()：清空集合元素
     5.isEmpty()：判断当前集合是否为空
     6.contains(Object obj)：判断当前集合中是否包含obj
     7.containsAll(Collection coll1)：判断形参coll1中的所有元素是否都存在于当前集合中
     8.remove(Object obj)：从当前集合中移除obj元素
     9.removeAll(Collection coll1)：差集：从当前集合中移除coll1中所有的元素
     10.retain(Object coll1)：交集：获取当前集合和coll1集合的交集，并返回给当前集合
     11.equals(Object obj)：要想返回true，需要判断当前集合和形参集合的元素都相同
     12.hashCode()：返回当前对象的哈希值
     13.集合--->数组：toArray()
        数组--->集合：调用Arrays类的静态方法aslist()；但用时需小心，需new包装类才能不返回地址值，才能返回元素
     14.iterator()：返回Iterate接口的实例，用于遍历集合元素。放在IterateTest.java中
     */

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);

//        Person p = new Person("Jerry", 20);
//        coll.add(p);
        coll.add(new Person("Jerry", 20));

        // 6.contains(Object obj)：判断当前集合中是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains); // true

        System.out.println(coll.contains(new String("Tom")));
//        System.out.println(coll.contains(p)); // true
        System.out.println(coll.contains(new Person("Jerry", 20))); // 未在Person里重写equals方法时是false，重写了之后便是true了

        // 7.containsAll(Collection coll1)：判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 8.remove(Object obj)：从当前集合中移除obj元素
        coll.remove(1234);
        System.out.println("remove:" + coll);

        coll.remove(new Person("Jerry", 20));
        System.out.println("remove:" + coll);

        // 9.removeAll(Collection coll1)：差集：从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123, 4567);
        coll.removeAll(coll1);
        System.out.println("removeAll:" + coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 10.retain(Object coll1)：交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123, 456, 789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        // 11.equals(Object obj)：要想返回true，需要判断当前集合和形参集合的元素都相同
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 12.hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // 13.集合--->数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 拓展：数组--->集合：调用Arrays类的静态方法aslist()，但用时需小心，需new包装类才能不返回地址值，才能返回元素
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456}); // ---> 这里new的不是包装类
//        System.out.println(arr1); // [[I@59a6e353]
        System.out.println(arr1.size()); // 1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
//        System.out.println(arr2); // [123, 456]
        System.out.println(arr2.size()); // 2

        // 14.iterator()：返回Iterate接口的实例，用于遍历集合元素。放在IterateTest.java中
    }

}