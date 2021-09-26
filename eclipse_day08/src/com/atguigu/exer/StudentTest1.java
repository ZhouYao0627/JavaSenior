package com.atguigu.exer;

/**
 * @author：ZhouYao
 * @create：2021-09-21 21:55
 */
public class StudentTest1 {


    public void initial(Student[] stus) {
        for (int i = 0; i < stus.length; i++) {
            stus[i] = new Student();

            // 年级：[1,6] random是前闭后开 8:58 随机数a~b公式：int value = (int)(Math.random()*(b-a+1)+a); 大于等于一年级，小于七年级
            stus[i].setNumber(i + 1);
            stus[i].setState((int) (Math.random() * (6 - 1 + 1) + 1));
            stus[i].setScore((int) (Math.random() * (100 - 0 + 1) + 0));
        }
    }

    public void print(Student[] stus) {
        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i].toString());
        }
    }


    public void searchState(Student[] stus, int state) {
        for (int i = 0; i < stus.length; i++) {
            if (stus[i].getState() == 3)
                System.out.println(stus[i].toString());
        }
    }


    public void sort(Student[] stus) {
        for (int i = 0; i < stus.length - 1; i++) {
            for (int j = 0; j < stus.length - 1 - i; j++) {
                if (stus[j].getScore() > stus[j + 1].getScore()) {
                    // 注：下方交换的不是成绩，而是成绩的对象
                    Student temp = stus[j];
                    stus[j] = stus[j + 1];
                    stus[j + 1] = temp;
                }
            }
        }


    }


}


