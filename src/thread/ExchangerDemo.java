package thread;

import java.util.concurrent.Exchanger;

/**
 * Create by fengguofei
 * Date: 2018/5/20
 * Time: 12:49
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        ExchangerRunnable exchangerRunnable = new ExchangerRunnable(exchanger, "A");
        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

        new Thread(exchangerRunnable).start();
        new Thread(exchangerRunnable2).start();
    }
}

class ExchangerRunnable implements Runnable{
    Exchanger exchanger = null;
    Object object = null;

    public ExchangerRunnable(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    @Override
    public void run() {
        try{
            Object previous = this.object;
            this.object = this.exchanger.exchange(this.object);
            System.out.println(Thread.currentThread().getName() + " exchanged "
                    + previous + " for " + this.object);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
