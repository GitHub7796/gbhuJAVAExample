package main.gbhu.dateLearn;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * java7之前的api
 */
public class JavaUtilXXX {
    /**
     * 日期时间
     */
    @Test
    public void testUtilDate() {
        java.util.Date date = new java.util.Date();
        long time = date.getTime();
        // 可以由毫秒时间创建
        java.util.Date dateFromLong = new java.util.Date(System.currentTimeMillis());

        //可以进行比较
        int compare = date.compareTo(dateFromLong);
        //也有快捷的方法如下
        boolean isBefore = date.before(dateFromLong);
        boolean isAfter = date.after(dateFromLong);

        System.out.println("date:"+date);
        //date:Fri May 24 11:44:52 CST 2024
        System.out.println("time:"+time);
        //time:1716522292782
        System.out.println("dateFromLong:" + dateFromLong);
        //dateFromLong:Fri May 24 11:44:52 CST 2024
    }

    /**
     * 日历
     */
    @Test
    public void testUtileCalender() {
        // 根据时区获得日期
        Calendar calendarInstance=Calendar.getInstance();
        Calendar calendar = new GregorianCalendar();

        //获取 年、月、日、小时、分钟、秒、毫秒和时区
        int year       = calendar.get(Calendar.YEAR);                             //2024
        int month      = calendar.get(Calendar.MONTH);                            //4
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1   //27
        int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);                      //2
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);                     //22
        int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);                    //5
        int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock     //4
        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock     //16
        int minute     = calendar.get(Calendar.MINUTE);                           //58
        int second     = calendar.get(Calendar.SECOND);                           //30
        int millisecond= calendar.get(Calendar.MILLISECOND);                      //506

        //设置日历的这些字段
        calendar.set(Calendar.YEAR, 2009);
        calendar.set(Calendar.MONTH, 11); // 11 = december
        calendar.set(Calendar.DAY_OF_MONTH, 24); // christmas eve

        //添加年、月、日、小时等
        //add one day
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        //减掉1天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
    }

    /**
     * 时区
     */
    @Test
    public void testUtilTimeZone() {
        //根据系统时区进行创建
        TimeZone timeZoneDefault= TimeZone.getDefault();
        //创建指定时区
        TimeZone timeZoneEurope = TimeZone.getTimeZone("Europe/Copenhagen");
        //从日历中获取时区
        Calendar calendar = new GregorianCalendar();
        TimeZone timeZone = calendar.getTimeZone();

        //获取时区名、ID、偏移量【给定时区在给定时间到UTC的偏移量（以毫秒为单位）】
        timeZone.getDisplayName();
        timeZone.getID();
        timeZone.getOffset( System.currentTimeMillis() );

        //切换日历的时区,时间（毫秒）相同，但是日期的小时不同
        long timeInMillis = calendar.getTimeInMillis();
        System.out.println("timeCPH  = " + timeInMillis);
        //timeCPH  = 1716805414300
        System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));
        //hour     = 18
        calendar.setTimeZone(timeZoneEurope);
        long timeInMillisAfter = calendar.getTimeInMillis();
        System.out.println("timeCPH  = " + timeInMillisAfter);
        //timeCPH  = 1716805414300
        System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));
        //hour     = 12
    }

}
