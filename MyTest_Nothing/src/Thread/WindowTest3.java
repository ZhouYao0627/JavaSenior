package Thread;

/**
 * @author：ZhouYao
 * @create：2021-07-05 10:18
 */
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private synchronized void show(){
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
}

public class WindowTest3 {

    public static void main(String[] args) {

        Window1 w = new Window1();

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
