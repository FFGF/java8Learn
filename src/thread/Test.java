package thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Create by fengguofei
 * Date: 2018/5/18
 * Time: 13:17
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        System.out.println("---程序开始运行---");
        int cpuCoreNumber = Runtime.getRuntime().availableProcessors();
        System.out.println("cpuCoreNumber: "+cpuCoreNumber);
        Date date1 = new Date();
        int taskSize= 5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        List<Future> list = new ArrayList<>();
        for(int i =0; i< taskSize; i++){
            Callable c = new MyCallable(i+ " ");
            Future f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();
        for(Future f:list){
            System.out.println(">>>" + f.get().toString());
        }
        Date date2 = new Date();
        System.out.println("---程序结束运行---, 程序运行时间【"
                            + (date2.getTime() - date1.getTime()) + "毫秒】");
    }
}
class MyCallable implements Callable<Object>{
    private String taskNum;

    MyCallable(String taskNum){
        this.taskNum = taskNum;
    }
    @Override
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTemp1 = new Date();
        Thread.sleep(1000);
        Date dateTemp2 = new Date();
        long time = dateTemp2.getTime()  - dateTemp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果，当前任务时间【" + time + "毫秒】";
    }
}


