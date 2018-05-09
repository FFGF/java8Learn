package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Create by fengguofei
 * Date: 2018/5/7
 * Time: 18:22
 */
public class Stop {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 5, 7, 3, 3);
        boolean allMatch = list.stream().allMatch(x -> x > 2);
        System.out.println(allMatch);

        Optional<Integer> first = list.stream().max(Integer::compareTo);
        Integer val = first.get();
        System.out.println(val);

        Integer result = list.stream().reduce(2, Integer::sum);
        System.out.println(result);

        Optional<Integer> optional = list.stream().reduce(Integer::sum);
        System.out.println(optional.get());

        List<Integer> resultList = list.stream().collect(Collectors.toList());
        System.out.println(resultList);

        Set<Integer> resultSet = list.stream().collect(Collectors.toSet());
        System.out.println(resultSet);



    }
}
