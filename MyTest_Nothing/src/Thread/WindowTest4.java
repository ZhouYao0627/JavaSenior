package Thread;

/**
 * @author：ZhouYao
 * @create：2021-07-05 10:30
 */
class Window4 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
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

            System.out.println(getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }

    public Window4(String name) {
        super(name);
    }

}

public class WindowTest4 {

    public static void main(String[] args) {
        Window2 t1 = new Window2("窗口1"); // 这相当于三个对象，三个线程
        Window2 t2 = new Window2("窗口2");
        Window2 t3 = new Window2("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
