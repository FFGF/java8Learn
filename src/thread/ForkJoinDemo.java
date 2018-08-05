package thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Create by fengguofei
 * Date: 2018/5/20
 * Time: 13:46
 */
public class ForkJoinDemo {


    public static void main(String[] args) {
        MyRecursiveTask myRecursiveAction = new MyRecursiveTask(24);
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        System.out.println(forkJoinPool.invoke(myRecursiveAction));
    }
}
class MyRecursiveTask extends RecursiveTask<Long> {
    private long workLoad = 0;

    public MyRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected Long compute() {
        if(this.workLoad > 16){
            System.out.println("Splitting wordLoad : " + this.workLoad);

            List<MyRecursiveTask> subtasks = new ArrayList<>();
            
            subtasks.addAll(createSubtasks());

            for(MyRecursiveTask subtask: subtasks){
                subtask.fork();
            }
            long result = 0;

            for(MyRecursiveTask subtask: subtasks){
                result += subtask.join();
            }
            return result;
        }else{
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }

    private List<MyRecursiveTask> createSubtasks() {
        List<MyRecursiveTask> subtasks = new ArrayList<>();

        MyRecursiveTask subtask1 = new MyRecursiveTask(this.workLoad / 2);
        MyRecursiveTask subtask2 = new MyRecursiveTask(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }
}