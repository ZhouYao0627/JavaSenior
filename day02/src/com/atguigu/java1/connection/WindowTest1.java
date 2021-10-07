package com.atguigu.java1.connection;

/**
 * 例子：创建三个窗口卖票，总票数为100张；使用实现Runnable接口的方式
 * 1.问题：卖票过程中，出现了重票、错票--->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其它线程参与进来，也操作车票
 * 3.如何解决：当一个线程a在操作ticket的时候，其它线程不能参与进来。直到线程a操作完ticket时，其它线程才可以操作ticket。即使线程a出现了阻塞，也不能被改变
 * 4.在Java中，我们通过同步机制，来解决线程的安全问题
 *
 * 方式一：同步代码块 ---> 看WindowTest1，WindowTest2
 *
 * synchronized(同步监视器){
 * // 需要被同步的代码
 * }
 * 说明：1.操作共享数据的代码，即为需要被同步的代码。 --->不能包含代码多了，也不能包含代码少了
 *      2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据    （操作共享数据的代码需要用synchronized包起来）
 *      3.同步监视器：俗称：锁。如何一个类的对象，都可以充当锁。--->要求：多个线程必须要共用同一把锁
 *
 * 补充：在实现Runnable接口创建多线程的方式中，我们可以考虑this来充当同步监视器。
 * 补充：在继承Thread类创建多线程的方式中，慎用this充当同步监视器；可以考虑使用当前类充当同步监视器
 *
 * 方式二：同步方法 ---> 看WindowTest3，WindowTest4
 * 如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的
 *
 * 方式三在Java1里的LockTest中(lock和unlock的用法)
 * 方式三在Java2里的ThreadNew中(Callable的用法)
 * 方式四在Java2里的ThreadPool(使用线程池)
 * 方式总体为四种：继承Thread类，实现Runnable，实现Callable，使用线程池
 *
 * 5.同步的方式，解决了线程的安全问题。<---好处
 * 操作同步代码时，只能有一个线程参与，其它线程等待。相当于是一个单线程的过程，效率低。<---局限性
 *
 * @author：ZhouYao
 * @create：2021-07-04 11:01
 */
class Window1 implements Runnable {

    private int ticket = 100;
//    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // synchronized (obj) //此时的this：唯一的Window1的对象。
            // 即调run()方法的就是this，而run()方法是在Window1中定义的，所以Window1的对象就是this
            synchronized (this) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100); // 加上sleep之后，0和1的概率大大提升了；即使不加sleep也会出现0和1，只是概率较小
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1(); // 这相当于一个对象，三个线程

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