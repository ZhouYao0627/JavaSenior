package com.atguigu.java;

/**
 * 使用同步方法解决继承Thread类的方式中的线程安全问题
 *
 * @author：ZhouYao
 * @create：2021-07-04 16:22
 */
class Window4 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) { // 这里是死循环，自己可编写出循环的语句
            show();
        }
    }

    private static synchronized void show() { // 同步监视器：Window4.class
        // private synchronized void show() { // 同步监视器：t1,t2,t3。此种解决方式是错误的
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }

    public Window4(String name) {
        super(name);
    }
}

public class WindowTest4 {

    public static void main(String[] args) {
        Window4 t1 = new Window4("窗口1"); // 这相当于三个对象，三个线程
        Window4 t2 = new Window4("窗口2");
        Window4 t3 = new Window4("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
