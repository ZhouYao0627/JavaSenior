package com.atguigu.java;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * @author：ZhouYao
 * @create：2021-07-14 10:11
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;

        System.out.println("*******toString()*********");
        // toString():
        System.out.println(summer.toString());

        System.out.println("*******values()*********");
        // values():
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        System.out.println("*******valueOf(String objName)*********");
        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);

        winter.show();
    }

}

interface Info {
    void show();
}

// 使用enum关键字来定义枚举类
enum Season1 implements Info {
    // 1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋风送爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冬日渐寒") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    // 2.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    // 3.私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4.其它诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    // 4.其它诉求2：提供toString()
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

    // 重写的抽象方法(共同的，即调用的show方法输出的都是下面这句话)
//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

}
