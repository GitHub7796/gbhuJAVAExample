package main.gbhu.dateLearn;

import org.junit.Test;

public class JavaSqlXXX {
    @Test
    public void test() {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date);
        //2024-05-24
        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        //2024-05-24 18:01:50.62
        timestamp.setNanos(123456);
        System.out.println(timestamp);
        //2024-05-24 18:01:50.000123456
        System.out.println(timestamp.getNanos());
        //123456
    }
}
