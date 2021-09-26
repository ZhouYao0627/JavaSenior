package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *       比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *      重要的代码分别在day05-java2-CollectionTest，day06-java-ListTest，day06-java1-SetTest，day07-java-MapTest
 *
 * 三、Collection接口中的方法的使用
 *
 * @author：ZhouYao
 * @create：2021-07-14 18:00
 */
public class CollectionTest {

     /* 这里只有前五个方法，后面的在day06的java的CollectionTest里
     1.add(Object e)：将元素e添加到集合coll中
     2.size()：获取添加的元素的个数
     3.addAll(COllection coll1)：将coll1集合中的元素添加到当前的集合中
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
     14.iterator()：返回Iterate接口的实例，用于遍历集合元素。放在IterateTest.java中
     */

    @Test
    public void test1() {
        Collection coll = new ArrayList();

        // 1.add(Object e)：将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        // 2.size()：获取添加的元素的个数
        System.out.println(coll.size()); // 4

        Collection coll1 = new ArrayList();

        // 3.addAll(COllection coll1)：将coll1集合中的元素添加到当前的集合中
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size()); // 6
        System.out.println(coll); // [AA, BB, 123, Wed Jul 14 21:33:59 CST 2021, 456, CC]

        // 4.clear()：清空集合元素
        coll.clear();

        // 5.isEmpty()：判断当前集合是否为空
        System.out.println(coll.isEmpty());


    }





}
















