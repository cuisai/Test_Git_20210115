package com.sai.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author sai
 * @Description cs
 * @Time 2020-11-25 10:40
 */
public class Demo {
    public static void main(String[] args) throws ParseException {

        LocalDateTime of1 = LocalDateTime.of(2019, 9, 25, 1, 1);//2018-9-25 01:01
        LocalDateTime of2 = LocalDateTime.of(2020, 9, 25, 23, 16); //2019-9-25 23:16
        //System.out.println(monthDiff(of1,of2));//相差月份 12
        //System.out.println(dateDiff(of1,of2));//相差天数 365

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String a = "2020-01-01";
        Date parse = sdf.parse(a);
        System.out.println(parse);

        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int i = calendar.get(Calendar.YEAR);
        System.out.println(i);

    }

    /**
     * 计算两个时间点的天数差
     * @param dt1 第一个时间点
     * @param dt2 第二个时间点
     * @return int，即要计算的天数差
     */
    public static int dateDiff(LocalDateTime dt1,LocalDateTime dt2){
        //获取第一个时间点的时间戳对应的秒数
        long t1 = dt1.toEpochSecond(ZoneOffset.ofHours(0));
        //获取第一个时间点在是1970年1月1日后的第几天
        long day1 = t1 /(60*60*24);
        //获取第二个时间点的时间戳对应的秒数
        long t2 = dt2.toEpochSecond(ZoneOffset.ofHours(0));
        //获取第二个时间点在是1970年1月1日后的第几天
        long day2 = t2/(60*60*24);
        //返回两个时间点的天数差
        return (int)(day2 - day1);
    }

    /**
     * 获取两个时间点的月份差
     * @param dt1 第一个时间点
     * @param dt2 第二个时间点
     * @return int，即需求的月数差
     */
    public static int monthDiff(LocalDateTime dt1,LocalDateTime dt2){
        //获取第一个时间点的月份
        int month1 = dt1.getMonthValue();
        //获取第一个时间点的年份
        int year1 = dt1.getYear();
        //获取第二个时间点的月份
        int month2 = dt2.getMonthValue();
        //获取第二个时间点的年份
        int year2 = dt2.getYear();
        //返回两个时间点的月数差
        return (year2 - year1) *12 + (month2 - month1);
    }

}
