package thread;

/**
 * Create by fengguofei
 * Date: 2018/5/20
 * Time: 16:57
 */
public class SleepDemo {

    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) {
        SleepDemo test = new SleepDemo();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();

        thread1.start();
        thread2.start();
    }

    public class MyThread extends Thread{

        public void run(){
            synchronized (object){
                i++;
                System.out.println("i:" + i);
                try{
                    System.out.println("线程" + Thread.currentThread().getName() + "进入睡眠状态");
                    Thread.currentThread().sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束");
                i++;
                System.out.println("i:" + i);
            }
        }
    }

}


