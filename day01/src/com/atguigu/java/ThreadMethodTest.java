package com.atguigu.java;

/**
 * 测试Thread中的常用方法：
 * 1.start():启动当前线程；调用当前线程的run()
 * 2.run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread ():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态
 * 8.stop:已过时。当执行此方法时，强制结束当前线程
 * 9.sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒的时间内，当前线程是阻塞状态
 * 10.isAlive():判断当前线程是否存活
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY 10
 * MIN PRIORITY 1
 * NORM_PRIORITY 5 --->默认的优先级
 * 2.如何获取和设置当前线程的优先级：
 * setPriority():获取线程的优先级
 * getPriority(int p):设置线程的优先级
 *
 * 说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程在高概率的情况下被执行，
 * 并不意味着只有当高优先级的线程执行完低优先级的线程才执行。
 *
 * @author：ZhouYao
 * @create：2021-07-03 16:43
 */

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

//                try {
//                    sleep(10); // 1000毫秒，即1秒
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(getName() + ":" + getPriority() + ":" + i); // 因为这就是在线程里面，故可以，也可以写完整：Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i
            }

//            if (i % 20 == 0) {
//                yield(); // 相当于this.yield()    this指的是当前类的对象，即h1   也相当于Thread.currentThread().yield()
//            }

        }
    }

    public HelloThread(String name) {
        super(name);
    }
}

public class ThreadMethodTest {

    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread1"); // 相当于通过构造器的方式命名

//        h1.setName("线程一");

        // 设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        // 给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if (i == 20) {
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        }
        System.out.println(h1.isAlive());
    }
}