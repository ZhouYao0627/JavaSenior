package com.atguigu.java2;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员 (Clerk)，而消费者 (Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如 :20)，
 * 如果生产者试图生产更多的产品，店员会叫生产者[停一下]，
 * 如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者[等一下]，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1.是否是多线程问题？ 是，生产者线程，消费者线程
 * 2.是否有共享数据？ 是，店员(或产品)
 * 3.如何解决线程安全问题？ 同步机制，有三种方法
 * 4.是否涉及线程的通信？ 是
 *
 * @author：ZhouYao
 * @create：2021-07-06 20:49
 */
class Clerk {

    private int productNum = 0;

    public synchronized void procuceProduct() {

        if (productNum < 20) {
            productNum++;

            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productNum + "个产品");

            notify();

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void cusumeProduct() {

        if (productNum > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productNum + "个产品");
            productNum--;

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

class Producer extends Thread {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品.....");
        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.procuceProduct();
        }
    }
}

class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品.....");
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.cusumeProduct();
        }
    }
}

public class ProductTest {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        Customer c1 = new Customer(clerk);
        Customer c2 = new Customer(clerk);

        p1.setName("生产者1");
        c1.setName("消费者1");
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }


}
