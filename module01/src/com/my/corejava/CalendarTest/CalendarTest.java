package com.my.corejava.CalendarTest;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarTest {
    public static void main(String[] args) {
        CalendarTest.displayCalendar();
    }
    public static void displayCalendar(){
        //构造一个表示当前日期的对象
        LocalDate date = LocalDate.now();
        //获取月份
        int month = date.getMonthValue();
//        Month a = date.getMonth(); 枚举类型
//        System.out.println(a);
//        System.out.println(month);
        //获取天
        int today = date.getDayOfMonth();
//        System.out.println(today);//25
        //生成当前日期之前的today-1天，也就是每个月的第一天
        date = date.minusDays(today - 1);
//      得到当前日期是星期几，作为DyaOfWeek类的一个实例返回*此处是每个月的第一天
        DayOfWeek weekday = date.getDayOfWeek();
//      按照ISO-8601 standard, from 1 (Monday) to 7 (Sunday).
        int value = weekday.getValue();
/*
        System.out.println(value);//5
        System.out.println(weekday);//FRIDAY
*/
        int year = date.getYear();
        System.out.println("***********"+year+"*************");
        System.out.println();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        //缩进
        for (int i = 1; i < value; i++)
            System.out.print("    ");
        //当前月份
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            //生成当前日期之后的1天
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1)
                System.out.println();



        }
    }
}
