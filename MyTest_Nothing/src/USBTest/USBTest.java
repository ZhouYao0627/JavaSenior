package USBTest;

/**
 * @author：ZhouYao
 * @create：2021-07-24 21:24
 */

/*
 * 	接口的使用
 *  1.接口使用上也满足多态性（因接口不可实例化，故需其子类来进行操作）
 *  2.接口，实际上就是定义了一种规范
 *  3.开发中，面向接口编程
 *
 */
public class USBTest {

    public static void main(String[] args) {

        Computer com = new Computer();
        // 匿名对象就直接new一个实现类；匿名实现类，就new USB接口。

        // 1.创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash(); // USB flash = new Flash();也是可以的
        com.TransferData(flash);

        // 2.创建了接口的非匿名实现类的匿名对象
        com.TransferData(new Printer());

        // 3.创建了接口的匿名实现类的非匿名对象
        USB phone = new USB() {

            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机结束工作");
            }

        };

        // 4.创建了接口的匿名实现类的匿名对象
        com.TransferData(new USB() {
            @Override
            public void start() {
                System.out.println("mp3开始工作");
            }

            @Override
            public void stop() {
                System.out.println("mp3结束工作");
            }
        });

    }

}

class Computer {

    public void TransferData(USB usb) { // USB usb = new Flash();

        usb.start();

        System.out.println("具体的传输细节");

        usb.stop();
    }

}

interface USB {
    // 常量：定义了长、宽、最大最小的传输速度等

    void start();

    void stop();
}

// U盘
class Flash implements USB {

    @Override
    public void start() {
        System.out.println("U盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");

    }

}

// 打印机
class Printer implements USB {

    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");

    }
}

