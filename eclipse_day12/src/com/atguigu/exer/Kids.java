package com.atguigu.exer;

/**
 * @author：ZhouYao
 * @create：2021-09-22 18:42
 */
public class Kids extends ManKind {

    private int yearsOld;

    public void yearsOld() {
        System.out.println("I am " + yearsOld);
    }


    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
}
