package thread;

/**
 * Create by fengguofei
 * Date: 2018/5/10
 * Time: 9:32
 */
class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;

    RunnableDemo(String name){
        threadName = name;
        System.out.println("Creating " + threadName);
    }
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try{
            for(int i=4; i>0; i--){
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class ThreadDemo extends Thread{
    private Thread t;
    private String threadName;

    ThreadDemo(String name){
        threadName = name;
        System.out.println("Creating " + threadName);
    }
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try{
            for(int i=4; i>0; i--){
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);

            }
        }catch (InterruptedException e){
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class TestThread{
    public static void main(String[] args) {
        ThreadDemo R1 = new ThreadDemo("Thread-1");
        R1.start();

        ThreadDemo R2 = new ThreadDemo("Thread-2");
        R2.start();
    }
}
