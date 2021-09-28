package com.atguigu.exer3;

/**
 * @author：ZhouYao
 * @create：2021-09-28 17:43
 */

/*
 * 定义一个 Circle 类，声明 redius 属性，提供 getter 和 setter 方法
 */
public class Circle {

    private Double radius;

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Circle() {
        super();
    }

    public Circle(Double radius) {
        super();
        this.radius = radius;
    }

}

