package main.gbhu.streamTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOther {
    @Test
    public void test01() {
        /**
         * 删除下述 list2 中 姓名重复的数据
         */
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("001", "王虎", "001"),
                Arrays.asList("002", "王虎", "002"),
                Arrays.asList("003", "李明", "003"),
                Arrays.asList("004", "王虎", "004"),
                Arrays.asList("005", "李明", "005"),
                Arrays.asList("006", "王虎", "006")
        );

        // 使用Java 8的Stream API删除每个子列表中第二个元素相同的数据，只保留一个
        List<List<String>> result = listOfLists.stream()
                .collect(Collectors.toMap(subList -> subList.get(1), // 使用第二个元素作为key
                        subList -> subList, // 保留第一个出现的相同key的元素
                        (existing, replacement) -> existing)) // 如果key相同，保留已存在的元素
                .values()
                .stream()
                .collect(Collectors.toList());

        // 打印结果
        result.forEach(System.out::println);
        System.out.println();
        listOfLists.forEach(System.out::println);
    }
}

