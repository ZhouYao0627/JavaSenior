package com.atguigu.exer3;

/**
 * @author：ZhouYao
 * @create：2021-09-28 17:43
 */
interface CompareObject {

    /**
     * 若返回值是0，代表相等；若为正数，代表当前对象大；负数代表当前对象小
     *
     * @param o
     * @return
     */
    public int compareTo(Object o);


}
