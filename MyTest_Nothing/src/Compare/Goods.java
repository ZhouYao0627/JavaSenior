package Compare;

/**
 * @author：ZhouYao
 * @create：2021-07-13 9:39
 */
public class Goods implements Comparable {

    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    /*
    3. 重写compareTo(obj)的规则：
       如果当前对象this大于形参对象obj，则返回正整数，
       如果当前对象this小于形参对象obj，则返回负整数，
       如果当前对象this等于形参对象obj，则返回零。
    4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
     */

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            // 方式一：
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return 0;
            }
            // 方式二：
//            return Double.compare(this.price, goods.price);
        }

        throw new RuntimeException("传入的数据类型不一致!");

    }
}
