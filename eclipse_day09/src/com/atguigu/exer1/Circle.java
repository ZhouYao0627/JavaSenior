package com.atguigu.exer1;

/**
 * @author：ZhouYao
 * @create：2021-09-22 14:06
 */
public class Circle {

    private double radius;

    public double findArea() {

        return Math.PI * Math.pow(radius, 2);

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}








