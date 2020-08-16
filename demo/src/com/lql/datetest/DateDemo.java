package com.lql.datetest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDemo {
    public static void main(String[] args) {

        //获取calendar对象
        //两种方式
        Calendar c1 =  Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();


        int year = c1.get(Calendar.YEAR);
        int month = c1.get(Calendar.MONTH);
        int day = c1.get(Calendar.DATE);
        int hour = c1.get(Calendar.HOUR_OF_DAY);
        int minute = c1.get(Calendar.MINUTE);
        int second = c1.get(Calendar.SECOND);
        int milliSecond = c1.get(Calendar.MILLISECOND);

        StringBuilder sb = new StringBuilder();
        sb.append("当前时间是:").append(year).append("年").append(month).append("月").append(day).append("日").append(hour).append("小时")
                .append(minute).append("分").append(second).append("秒").append(milliSecond).append("毫秒");
        System.out.println(sb.toString());


        //时间格式化函数
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
        String nowDate = df.format(new Date());
        System.out.println(nowDate);

    }
}
