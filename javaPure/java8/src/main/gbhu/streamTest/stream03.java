package main.gbhu.streamTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author gb.hu
 * @CreateDate 2022/6/29 19:41
 * @Team RISK_CTL_ALGO
 */
public class stream03 {
    /**
     * 映射
     * 1.map(Function<T, R>) 将function作用于stream没一个函数
     * Function<T, R> 函数型接口
     * 2.flatmap 以一个函数作为参数，并将函数返回的stream中元素合并为一个大的stream
     * 从flatmap定义看,需要以一个函数作为参数，函数的返回值是 Stream
     * flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
     */
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test01() {
        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        strList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        emps.stream()
                .map(employee -> employee.getName())
                .forEach(System.out::println);
    }

    @Test
    public void test02() {
        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        //需注意 map、flatmap 都以 返回Stream<Character>作为参数
        //flatmap 返回 Stream<Character>
        Stream<Character> stream1 = strList.stream()
                .flatMap(stream03::filterCharacter);
        stream1.forEach(System.out::println);
        //map 返回 Stream<Stream<Character>>
        Stream<Stream<Character>> stream02=strList.stream()
                .map(stream03::filterCharacter);
        stream02.forEach(
                x -> x.forEach(System.out::println)
        );
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character c :
                str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
