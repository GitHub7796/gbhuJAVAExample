package main.gbhu.dateLearn;

import org.junit.Test;

import java.time.*;

public class JavaTimeXXX {
    @Test
    public void testInstant() {
        // 创建 Instant 实例
        Instant instant=Instant.now();
        //2024-05-27T12:02:19.931Z

        // 从历元开始的秒数
        instant.getEpochSecond();
        // 1716811364

        // 纳秒,Instant 中小于1秒的部分
        instant.getNano();
        // 98000000

        // 3s后的时刻
        instant.plusSeconds(3);
        // 3s前的时刻
        instant.minusSeconds(3);
    }

    @Test
    public void testDuration() throws InterruptedException {
        Instant first = Instant.now();
        Thread.sleep(1001);
        Instant second = Instant.now();
        // Duration 工厂方法创建 实例
        Duration duration=Duration.between(first,second);

        //获取秒数
        System.out.println(duration.getSeconds());
        //1

        //获取小于1s的部分，单位纳秒
        System.out.println(duration.getNano());
        //1000000

        // duration 都转化为纳秒
        System.out.println(duration.toNanos());
        //1001000000

        duration.toMillis();
        duration.toHours();
        duration.toDays();

        // duration 的计算
        Duration added      = duration.plusDays(3);
        Duration subtracted = duration.minusDays(3);
    }

    @Test
    public void testLocalDate() {
        LocalDate localDate=LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2024, 5, 28);

        //note:Month、DayOfWeek 都是枚举
        int   year       = localDate2.getYear();//2024
        Month month      = localDate2.getMonth();;//MAY
        int   dayOfMonth = localDate2.getDayOfMonth();//28
        int   dayOfYear  = localDate2.getDayOfYear();//TUESDAY
        DayOfWeek dayOfWeek = localDate2.getDayOfWeek();//149

        //localDate 计算
        localDate2.plusDays(1);
        localDate2.minusDays(1);
    }

    @Test
    public void testLocalTime() {
        //创建实例
        LocalTime localTime = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(21, 30, 59, 11001);

        //获取 时间的不同部分
        int hour = localTime2.getHour();//21
        int minute = localTime2.getMinute();//30
        int second = localTime2.getSecond();//59
        int nano = localTime2.getNano();//11001

        //计算
        LocalTime localTimeLater   = localTime.plusHours(3);
        LocalTime localTimeEarlier = localTime.minusHours(3);
    }

    @Test
    public void testLocalDateTime() {
        //创建实例
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 =
                LocalDateTime.of(2024, 05, 28, 13, 55, 36, 123);

        //获取日期时间的信息
        int year = localDateTime2.getYear();//2024
        Month month = localDateTime2.getMonth();//MAY
        int dayOfMonth = localDateTime2.getDayOfMonth();//28
        DayOfWeek dayOfWeek = localDateTime2.getDayOfWeek();//TUEDDAY
        int dayOfYear = localDateTime2.getDayOfYear();//149
        int hour = localDateTime2.getHour();//13
        int minute = localDateTime2.getMinute();//55
        int second = localDateTime2.getSecond();//36
        int nano = localDateTime2.getNano();//123

        //计算
        LocalDateTime localDateTime3 = localDateTime.plusYears(3);
        LocalDateTime localDateTime4 = localDateTime.minusYears(3);
    }

    @Test
    public void testZonedDate() {
        //创建实例1
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        //创建实例2
        //创建时区的3中方法
        ZoneId zoneId1 = ZoneId.systemDefault();
        ZoneId zoneId2 = ZoneId.of("UTC+1");
        ZoneId zoneId3 = ZoneId.of("Europe/Copenhagen");
        ZonedDateTime zonedDateTime2 =
                ZonedDateTime.of(2024, 05, 28, 23, 45, 59, 1234, zoneId1);

        //获取信息
        ZoneId zone = zonedDateTime2.getZone();//Asia/Shanghai
        int year = zonedDateTime2.getYear();//2024
        Month month = zonedDateTime2.getMonth();//MAY
        int dayOfMonth = zonedDateTime2.getDayOfMonth();//28
        DayOfWeek dayOfWeek = zonedDateTime2.getDayOfWeek();//TUEDDAY
        int dayOfYear = zonedDateTime2.getDayOfYear();//149
        int hour = zonedDateTime2.getHour();//23
        int minute = zonedDateTime2.getMinute();//45
        int second = zonedDateTime2.getSecond();//59
        int nano = zonedDateTime2.getNano();//1234

        //更改时区
        System.out.println(zonedDateTime2);//2024-05-28T23:45:59.000001234+08:00[Asia/Shanghai]
        ZonedDateTime zonedDateTime3 = zonedDateTime2.withZoneSameInstant(zoneId2);
        System.out.println(zonedDateTime3);//2024-05-28T16:45:59.000001234+01:00[UTC+01:00]

        //计算
        ZonedDateTime newZoneDateTime =
                zonedDateTime2.plus(Period.ofDays(3));
    }
}
