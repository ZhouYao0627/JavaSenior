package Thread;

/**
 * @author：ZhouYao
 * @create：2021-07-05 10:25
 */
class Window2 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (Window2.class) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100); // 加上sleep之后，0和1的概率大大提升了
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }

    public Window2(String name) {
        super(name);
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2("线程1");
        Window2 w2 = new Window2("线程2");
        Window2 w3 = new Window2("线程3");

        w1.start();
        w2.start();
        w3.start();
    }
}
