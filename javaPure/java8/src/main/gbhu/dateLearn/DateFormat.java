package main.gbhu.dateLearn;

import org.junit.Test;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormat {
    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date->String
        String dateString = format.format(new java.util.Date());
        //string->java.util.Date
        java.util.Date date = format.parse(dateString);
    }
    @Test
    public void testDateTimeFormatter() throws ParseException {
        //具体每个常量代表的含义 可以 查看源代码的注释
        DateTimeFormatter formatter=DateTimeFormatter.BASIC_ISO_DATE;
        //java.time.LocalDate->string
        String formattedDate = formatter.format(LocalDate.now());
        //string->java.time.LocalDate
        LocalDate localDate = LocalDate.parse(formattedDate, formatter);
        //2024-05-27

        //格式化带时区的日期
        String formattedZonedDate = formatter.format(ZonedDateTime.now());
        //20240527+0800
    }
}
