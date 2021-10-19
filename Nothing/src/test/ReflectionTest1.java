package test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 @author：ZhouYao
 @create：2021-10-19 9:56
 */
public class ReflectionTest1 {

    @Test
    public void test() throws ClassNotFoundException {
        // 方式一
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        // 方式二
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);
        // 方式三
        Class<?> clazz3 = Class.forName("test.Person");
        System.out.println(clazz3);
        // 方式四
        ClassLoader classLoader = ReflectionTest1.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("test.Person");
        System.out.println(clazz4);
    }

    @Test
    public void test1() throws Exception {

        Properties pros = new Properties();

        // 1.
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);

        // 2.
        ClassLoader classLoader = ReflectionTest1.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.prperties");
        pros.load(is);


        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user" + user + ",password" + password);
    }


    @Test
    public void test2() throws Exception {

        Class<?> clazz = Class.forName("test.Person");

        Field[] fields = clazz.getFields();
        for (Field f1 : fields) {
            System.out.println(f1);
        }

        Field[] fields1 = clazz.getDeclaredFields();
        for (Field f2 : fields1) {
            System.out.println(f2);
        }
    }

    @Test
    public void test3() throws Exception {
        Class<?> clazz = Class.forName("test.Person");

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field f : declaredFields) {
            // 1.
            int modifiers = f.getModifiers();
            System.out.println(modifiers);
        }
    }

    @Test
    public void test4() throws Exception {

        Class<?> clazz = Class.forName("test.Person");

        Person p = (Person) clazz.getConstructor().newInstance();

        Field id = clazz.getField("id");

        id.set(p, 10);

        Object o = id.get(p);
        System.out.println(o);
    }

    @Test
    public void test5() throws Exception {

        Class<?> clazz = Class.forName("test.Person");

        Person p = (Person) clazz.getDeclaredConstructor().newInstance();

        Field name = clazz.getDeclaredField("name");

        name.setAccessible(true);

        name.set(p, "miao");

        System.out.println(name.get(p));
    }

    @Test
    public void test6() throws Exception {

        ClassLoader classLoader = ReflectionTest1.class.getClassLoader();
        Class<?> clazz = classLoader.loadClass("test.Person");

        Person p = (Person) clazz.getDeclaredConstructor().newInstance();

        Method show = clazz.getDeclaredMethod("show", String.class);

        show.setAccessible(true);

        Object chn = show.invoke(p, "CHN");




    }


}
