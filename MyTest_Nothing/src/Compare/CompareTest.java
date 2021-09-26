package Compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author：ZhouYao
 * @create：2021-07-13 9:38
 */
public class CompareTest {

    @Test
    public void test1() {

        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));


    }


    @Test
    public void test2() {

        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("microsoftMouse", 43);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test3() {
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("huaweiMouse", 224);
        arr[5] = new Goods("microsoftMouse", 43);

        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
                if (o1 instanceof Goods && o2 instanceof Goods) {

                    Goods goods1 = (Goods) o1;
                    Goods goods2 = (Goods) o2;

                    if (goods1.getName().equals(goods2.getName())) {
                        return Double.compare(goods1.getPrice(), goods2.getPrice());
                    } else {
                        return goods1.getName().compareTo(goods2.getName());
                    }

                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));

    }


}
