package com.atguigu.java2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信的例子：使用两个线程打印 1-100。线程1,线程2交替打印
 *
 * 涉及到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个
 * notifyAll():一旦执行此方法，就会唤醒被wait的线程
 *
 * 说明：
 * 1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中
 * 2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器，
 *   否则会出现IllegalMonitorStateException异常
 * 3.wait()，notify()，notifyAll()三个方法是定义在java.lang.object类中
 *
 * 面试题：sleep()和wait()的异同？
 * 1.相同点：一旦执行此方法，都可以使得当前的线程进入阻塞状态
 * 2.不同点：(1)两个方法声明的位置不同：Thread类中声明sleep(),Object类中声明wait()
 *          (2)调用的位置不同：sleep()可以在如何需要的场景下调用。wait()必须使用在同步代码块或同步方法中
 *          (3)关于是否释放同步监视器：如果两个方法都是使用在同步代码块或同步方法中，sleep()不会是否锁，wait()会释放锁。
 *
 * @author：ZhouYao
 * @create：2021-07-05 20:54
 */
class Number implements Runnable {

    private int number = 1;

    private ReentrantLock lock = new ReentrantLock();

    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {

                obj.notify();

                if (number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number ++;

                    // 使得调用如下wait()方法的线程进入阻塞状态
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {

    public static void main(String[] args) {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("1");
        t2.setName("2");

        t1.start();
        t2.start();
    }


}

//public void run() {
//    while (true) {
//        try {
//
//            lock.lock();
//
//            if (number <= 100) {
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println(Thread.currentThread().getName() + ":" + number);
//                number++;
//            } else {
//                break;
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//}