package thread;

/**
 * Create by fengguofei
 * Date: 2018/5/10
 * Time: 9:52
 */

class DisplayMessage implements Runnable{

    private String message;

    public DisplayMessage(String message){
        this.message = message;
    }
    @Override
    public void run() {
        while (true){
            System.out.println(message);
        }
    }
}

class GuessANumber extends Thread{
    private int number;
    public GuessANumber(int numnber){
        this.number = numnber;
    }
    public void run(){
       int counter = 0;
       int guess = 0;
       do{
           guess = (int) (Math.random() * 100 + 1);
           System.out.println(this.getName() + " guess " + guess);
           counter++;
       }while (guess != number);
        System.out.println("** Correct!" + this.getName() + "in" + counter + "guess.**");
    }
}

public class ThreadClassDemo {

    public static void main(String[] args) {
        Runnable hello = new DisplayMessage("Hello");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);
        thread1.setName("hello");
        System.out.println("Start hello thread...");
        thread1.start();

        Runnable bye = new DisplayMessage("Goodbye");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        System.out.println("Start goodbye thread...");
        thread2.start();

        System.out.println("Start thread3...");
        Thread thread3 = new GuessANumber(27);
        thread3.start();
        try{
            thread3.join();
        }catch (InterruptedException e){
            System.out.println("Thread interrupted.");
        }
        System.out.println("Start thread4...");
        Thread thread4 = new GuessANumber(5);
        thread4.start();
        System.out.println("main() is ending...");
    }

}
