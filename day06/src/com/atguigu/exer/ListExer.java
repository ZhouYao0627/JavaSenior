package com.atguigu.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：ZhouYao
 * @create：2021-07-15 23:02
 */
public class ListExer {
    /*
    区分List中remove(int index)和remove(Object obj) ---> 即需要判断想删的是元素还是对象
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        updateList(list);
        System.out.println(list); //
    }

    private void updateList(List list) {
//        list.remove(2); // ---> 删的是索引位置上的
        list.remove(new Integer(2)); // ---> 删的是对象
    }

}