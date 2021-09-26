package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author：ZhouYao
 * @create：2021-07-07 21:50
 */
class NumThread implements Callable {

    private int sum = 0;

    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {

        NumThread t1 = new NumThread();

        FutureTask futureTask = new FutureTask(t1);

        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }



}
