package streamTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author gb.hu
 * @CreateDate 2022/6/29 19:58
 * @Team RISK_CTL_ALGO
 */
public class stream04 {
    /**
     * sorted() 自然排序，按照待排序对象的 Comparable
     * sorted(Comparator com) 定制排序 Comparator
     * sorted(Comparator<? super T> comparator)
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
        emps.stream()
                .map(employee -> employee.getName())
                .sorted()
                .forEach(System.out::println);

        emps.stream()
                .sorted((x,y)->{
                    if (x.getAge() == y.getAge()) {
                        return x.getName().compareTo(y.getName());
                    } else {
                        return Integer.compare(x.getAge(), y.getAge());
                    }
                }).forEach(System.out::println);
    }
}
