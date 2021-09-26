package Thread;

/**
 * @author：ZhouYao
 * @create：2021-07-05 9:19
 */

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(getName() + ":" + getPriority() + ":" + i);
        }
    }
}

public class ThreadTest {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
//        t1.setName("分线程1");
        t1.start();

        MyThread t2 = new MyThread();
//        t2.setName("分线程2");
        t2.start();

//        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
        }
    }

}
