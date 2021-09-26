package SingletonTest;

/**
 * 懒汉式
 *
 * @author：ZhouYao
 * @create：2021-07-07 21:31
 */
class Order {

    private Order() {

    }

    private static Order instance = null;

    public static Order getInstance() {
        if (instance == null) {
            synchronized (Order.class) {
                if (instance == null) {
                    instance = new Order();
                }
            }
        }
        return instance;
    }


}

public class SingletonTest2 {

    public static void main(String[] args) {
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();

        System.out.println(order1 == order2);

    }

}
