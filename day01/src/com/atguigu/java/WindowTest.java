package com.atguigu.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张；使用继承Thread类的方式
 *
 * @author：ZhouYao
 * @create：2021-07-03 22:14
 */

class Window extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + "：卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

    public Window(String name) {
        super(name);
    }

}

public class WindowTest {

    public static void main(String[] args) {
        Window t1 = new Window("窗口1"); // 这相当于三个对象，三个线程
        Window t2 = new Window("窗口2");
        Window t3 = new Window("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
