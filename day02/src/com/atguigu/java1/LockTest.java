package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁 ---JDK5.0新增
 *
 * 面试题一：
 * 1.synchronized 与 lock的异同？
 *      相同：二者都可以解决线程安全问题
 *      不同：synchronized机制在执行完相应的同步代码以后，自动地释放监视器
 *           lock需要手动的启动同步(lock())，同时结束同步也需要手动的实现(unlock())
 * 2.优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 * 面试题二：
 * 如何解决线程的安全问题？有几种方式
 *
 * @author：ZhouYao
 * @create：2021-07-05 16:04
 */
class Window implements Runnable {

    private int ticket = 100;
    // 1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();  //若Window类不是实现Runnable，而是继承Thread，就需要在此行加static，否则下面的lock.lock等会错

    @Override
    public void run() {
        while (true) {
            try {

                // 2.调用锁定的方法：lock()
                lock.lock();

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票：当前票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 3.调用解锁的方法：unlock()
                lock.unlock();
            }
        }
    }
}


public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

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
