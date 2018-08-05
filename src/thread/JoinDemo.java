package thread;

/**
 * Create by fengguofei
 * Date: 2018/5/20
 * Time: 20:07
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        new Thread4("new thread").start();

        for(int i=0; i < 10; i++){
            if(i == 5){
                Thread4 th = new Thread4("joined thread");
                th.start();
                th.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class Thread4 extends Thread{
    public Thread4(String name) {
        super(name);
    }
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(getName() + " " + i);
        }
    }
}