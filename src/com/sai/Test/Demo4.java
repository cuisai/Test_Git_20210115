package com.sai.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author sai
 * @Description time
 * @Time 2020-10-30 22:20
 */
public class Demo4 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int  year1 = cal.get(Calendar.YEAR); //获取年份
        int  month=cal.get(Calendar.MONTH) + 1; //获取月份
        int  day1=cal.get(Calendar.DATE); //获取日
        int  hour=cal.get(Calendar.HOUR); //小时
        int  minute=cal.get(Calendar.MINUTE); //分
        int  second=cal.get(Calendar.SECOND); //秒
        int  WeekOfYear = cal.get(Calendar.DAY_OF_WEEK); //一周的第几天
        System.out.println( "现在的时间是：公元" +year1+ "年" +month+ "月" +day1+ "日      " +hour+ "时" +minute+ "分" +second+ "秒       星期" +WeekOfYear);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());					//放入Date类型数据

        calendar.get(Calendar.YEAR);					//获取年份
        calendar.get(Calendar.MONTH);					//获取月份
        calendar.get(Calendar.DATE);					//获取日

        System.out.println("MONTH: " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));

        calendar.get(Calendar.HOUR);					//时（12小时制）
        calendar.get(Calendar.HOUR_OF_DAY);				//时（24小时制）
        calendar.get(Calendar.MINUTE);					//分
        calendar.get(Calendar.SECOND);					//秒

        calendar.get(Calendar.DAY_OF_WEEK);				//一周的第几天

        //日期，获得年月日
        LocalDate ld = LocalDate.now();
        Month month1 = ld.getMonth();

        System.out.println(month);
        System.out.println(ld.getDayOfMonth());

        System.out.println("===================================================================");

        // System.currentTimeMillis() 当前毫秒值
        long time = System.currentTimeMillis();
        /*System.out.println("毫秒值1：" + time);

        // 纳秒值 通常用于想要十分精确的计算某段代码，连接数据库or网络连接等等过程所用时间
        System.out.println("纳秒值1：" + System.nanoTime());*/

        // 将毫秒值转换成易读的时间
        // 方法一：DateFormat.getDateInstance();
//        System.out.println(DateFormat.getDateInstance().format(time));

        /*
         * 方法二：SimpleDateFormat函数语法： G 年代标志符 y 年 M 月 d 日 h 时 在上午或下午 (1~12) H 时
         * 在一天中 (0~23) m 分 s 秒 S 毫秒 E 星期 D 一年中的第几天 F 一月中第几个星期几 w 一年中第几个星期 W
         * 一月中第几个星期 a 上午 / 下午 标记符 k 时 在一天中 (1~24) K 时 在上午或下午 (0~11) z 时区
         */
        /*System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E a"
                + " 今年的第" + "D" + "天").format(time));*/

        /*String osname = System.getProperty("os.name");
        String username = System.getProperty("user.name");

        System.out.println("当前操作系统是：" + osname);
        System.out.println("当前用户名：" + username);*/

        // 获取当前年
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(time));
        // 获取今天是今年的第几天
        int day = Integer.parseInt(new SimpleDateFormat("D").format(time));
        // 判断是不是闰年
        if (year % 4 == 0 && year % 100 != 0 || year % 100 == 0
                && year % 100 % 400 == 0) {
            System.out.println("是闰年，有366天");
            System.out.println("今年只有：" + (366 - day) + "天了");
        } else {
            System.out.println("不是闰年，有365天");
            System.out.println("今年只有：" + (365 - day) + "天了");
        }

        /*System.out.println("毫秒值2：" + System.currentTimeMillis());
        System.out.println("纳秒值2：" + System.nanoTime());*/

        System.out.println("========================");
        //获取系统时间
        Date date =new Date();

        //%tj表示一年中的第几天
        String strDate =String.format("%tj",date);

        //输出时间
        System.out.println(strDate);
        System.out.println(366 - Integer.parseInt(strDate));

    }
}
