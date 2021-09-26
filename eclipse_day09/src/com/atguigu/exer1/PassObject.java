package com.atguigu.exer1;

/**
 * @author：ZhouYao
 * @create：2021-09-22 14:14
 */
public class PassObject {

    public static void main(String[] args) {

        PassObject test = new PassObject();

        Circle c = new Circle();

        test.printAreas(c, 5);
    }


    public void printAreas(Circle c, int time) {

        for (int i = 1; i <= time; i++) {
            c.setRadius(i);

            System.out.println("radius " + c.getRadius() + "," + "Area " + c.findArea());
        }

    }

}
