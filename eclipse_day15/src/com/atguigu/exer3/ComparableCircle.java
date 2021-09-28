package com.atguigu.exer3;

/**
 * @author：ZhouYao
 * @create：2021-09-28 17:44
 */

/*
 * 定义一个 ComparableCircle 类，继承 Circle 类并且实现 CompareObject 接口。在 ComparableCircle 类中给出接口中方法 compareTo 的实现体，
 * 用来比较两个圆的半径大小。
 */
public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }

        if (o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) o;
            //错误的写法
//			return (int)(this.getRedius() - c.getRedius());
            //正确的方式一：
//			if(this.getRadius() > c.getRadius()){
//				return 1;
//			}else if(this.getRadius() < c.getRadius()){
//				return -1;
//			}else{
//				return 0;
//			}
            //当属性 radius 声明为 Double 类型时，可以调用包装类的方法
            //正确的方式二：
            return this.getRadius().compareTo(c.getRadius());
        } else {
            return 0;
//			throw new RuntimeException("传入数据类型不匹配");
        }
    }
}

