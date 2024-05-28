package main.gbhu.streamTest;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author gb.hu
 * @CreateDate 2022/6/29 20:20
 * @Team RISK_CTL_ALGO
 */
public class stream05 {
    /**
     * allMatch 检查流中所有元素是不是指定元素 return Boolean
     * anyMatch 检查流中是否有一个元素是指定元素 return Boolean
     * noneMatch 检查流中所有元素不是指定元素 return Boolean
     * findFirst 返回第一个元素
     * findAny 返回随机元素（串行流返回固定，并行流返回不固定）
     * count 返回流中元素个数
     * max 返回流中元素最大值
     * min 返回流中元素最小值
     */
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY));

    @Test
    public void test01() {
        boolean b = emps.stream()
                .allMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);

        b = emps.stream()
                .anyMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);

        b = emps.stream()
                .noneMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);

        Optional<Employee> first = emps.stream()
                .findFirst();
        System.out.println(first.get());

        Optional<Employee> any = emps.stream()
                .findAny();
        System.out.println(any.get());

    }

    @Test
    public void test02() {
        long count = emps.stream()
                .filter(employee -> employee.getStatus().equals(Employee.Status.FREE))
                .count();
        System.out.println(count);

        Optional<Double> rStream = emps.stream()
                .map(Employee::getSalary)
                .max(Double::compare);
        System.out.println(rStream.get());

        Optional<Employee> min = emps.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min.get());

    }
}
