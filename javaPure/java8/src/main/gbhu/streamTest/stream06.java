package main.gbhu.streamTest;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class stream06 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY));
    /**
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void test01() {
        /**
         * 返回值是 原来的值 还是 Optional
         * 是看是否获取的值可能为空
         *
         * list.stream().reduce(0, (x, y) -> x + y) 返回的是 Integer，因为list中的都是字面值，不可能为null
         * emps.stream().map(Employee::getSalary).reduce(Double::sum); 返回的是 Optional<Double> ，封装类型可能为null
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);

        System.out.println("------");

        Optional<Double> reduce = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce.get());

    }
    /**
     * collection 收集，将流转换为其他形式
     * 1. 统计信息，如 min max avg 等
     * 2. 更改结构，比如 拼接为str、转换为lst 等
     * 3. 分组分区，类似于groupby
     */
    @Test
    public void test3(){
        //转换结构

        //转换为 list
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("----------------------------------");

        //转换为 set 进行去重
        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);

        System.out.println("----------------------------------");

        // 转换为自定义的结构，这里为 HashSet
        HashSet<String> hs = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    @Test
    public void test4(){
        //max
        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));

        System.out.println(max.get());

        //min
        Optional<Employee> op = emps.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        System.out.println(op.get());

        //sum
        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println(sum);

        //avg
        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(avg);

        //count
        Long count = emps.stream()
                .collect(Collectors.counting());

        System.out.println(count);

        System.out.println("--------------------------------------------");

        //summarizingXXX 返回的结果XXXSummaryStatistics 可以进行getMax、getMin等操作
        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getMax());
        System.out.println(dss);
    }

    //分组
    @Test
    public void test5(){
        Map<Employee.Status, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println(map);
    }

    //多级分组
    @Test
    public void test6(){
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if(e.getAge() >= 60)
                        return "老年";
                    else if(e.getAge() >= 35)
                        return "中年";
                    else
                        return "成年";
                })));

        System.out.println(map);
    }

    //分区
    @Test
    public void test7(){
//        分为2组，>=5000 的为true组
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));

        System.out.println(map);
    }

    //拼接字符串
    @Test
    public void test8(){
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("," , "----", "----"));

        System.out.println(str);
    }

}
