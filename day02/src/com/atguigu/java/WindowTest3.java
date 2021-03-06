package com.atguigu.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显示的声明。
 * 2.非静态的同步方法，同步监视器是：this
 *   静态的同步方法，同步监视器是：当前类本身
 *
 * @author：ZhouYao
 * @create：2021-07-04 16:06
 */
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {  // 这里是死循环，自己可编写出循环的语句
            show();  // 将原本代码抽出构造一个方法，将其设计为同步方法
        }
    }

    private synchronized void show() { // 同步监视器：this
        if (ticket > 0) {

            try {
                Thread.sleep(100); // 加上sleep之后，0和1的概率大大提升了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3(); // 这相当于一个对象，三个线程

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}