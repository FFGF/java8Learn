package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Create by fengguofei
 * Date: 2018/5/19
 * Time: 14:23
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();
    }
}


class Waiter implements Runnable{

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            this.latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter Released");
    }
}

class Decrementer implements Runnable{

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(this.latch.getCount());
            this.latch.countDown();

            Thread.sleep(1000);
            System.out.println(this.latch.getCount());
            this.latch.countDown();

            Thread.sleep(1000);
            System.out.println(this.latch.getCount());
            this.latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}