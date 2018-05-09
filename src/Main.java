import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Integer num = 10000;
        // 起始时间
        List<Integer> list = new ArrayList<>();
        // 将10000-1存入list中
        for (int i = num; i >= 1; i--) {
            list.add(i);
        }
        LocalTime start = LocalTime.now();
        list.stream()// 获取串行流
                .sorted()// 按自然排序，即按数字从小到大排序
                .count();// count()是终止操作，有终止操作才会执行中间操作sorted()
        // 终止时间
        LocalTime end = LocalTime.now();
        // 时间间隔
        Duration duration = Duration.between(start, end);
        // 输出时间间隔毫秒值
        System.out.println(duration.toMillis());
        // 起始时间

        List<Integer> list1 = new ArrayList<>();
        // 将10000-1存入list中
        for (int i = num; i >= 1; i--) {
            list.add(i);
        }
        LocalTime start1 = LocalTime.now();
        list1.parallelStream()// 获取并行流
                .sorted()// 按自然排序，即按数字从小到大排序
                .count();// count()是终止操作，有终止操作才会执行中间操作sorted()

        // 终止时间
        LocalTime end1 = LocalTime.now();
        // 时间间隔
        Duration duration1 = Duration.between(start1, end1);
        // 输出时间间隔毫秒值
        System.out.println(duration1.toMillis());
    }

}
