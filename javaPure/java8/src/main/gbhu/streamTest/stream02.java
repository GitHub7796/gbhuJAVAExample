package main.gbhu.streamTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author gb.hu
 * @CreateDate 2022/6/29 19:20
 * @Team RISK_CTL_ALGO
 */
public class stream02 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
    /**
     * 筛选与切片
     * filter(lambda) 筛选 stream
     * limit 限制 stream 元素数量
     * skip(n) 跳过 stream 前 n 个元素
     * distinct 通过 hashcode() equals() 去重
     */
    @Test
    public void test01() {
        emps.stream()
                .filter(x->x.getAge()<40)
                .forEach(System.out::println);
    }
    @Test
    public void test02() {
        emps.stream()
                .limit(2)
                .forEach(System.out::println);
    }
    @Test
    public void test03() {
        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test04() {
        emps.stream()
                .skip(3)
                .forEach(System.out::println);
    }
}
