package Thread;

/**
 * @author：ZhouYao
 * @create：2021-07-05 9:30
 */
class MThread implements Runnable {
    @Override
    public void run() {
    }
}

public class ThreadTest1 {

    public static void main(String[] args) {

        MThread m1 = new MThread();
        new Thread(m1) {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        MThread m2 = new MThread();
        new Thread(m2) {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();


    }


}
