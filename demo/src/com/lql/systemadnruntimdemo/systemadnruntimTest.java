package com.lql.systemadnruntimdemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class systemadnruntimTest {
    private final static Double b = 1.3;
    public static void Thread(){
        new Thread() {
            int i = 0;
            public void run(){
                boolean flg = false;
                while(!flg){
                    try {
                        i++;
                        Runtime rt = Runtime.getRuntime();
                        Long l = rt.totalMemory();
                        Long l1 = rt.freeMemory();
                        DateFormat df = new SimpleDateFormat("HH:mm:ss SSS");
                        System.out.println(df.format(System.currentTimeMillis()));
                        System.out.println("JVM已分配内存总数: " + l+" byte");
                        System.out.println("JVM空闲内存总数: " + l1 +" byte");
                        System.out.println("JVM可调用的最大内存: " + rt.maxMemory()+" byte");
                        System.out.println("已使用内存："+ (rt.totalMemory() - rt.freeMemory())+" byte");
                        System.out.println("当前内存占有率为："+ String.format("%.2f",((l.doubleValue() - l1.doubleValue()) / rt.totalMemory()) * 100 ) +"%");
                        Thread.sleep(1000);
                        if(Double.parseDouble(String.format("%.2f",((l.doubleValue() - l1.doubleValue()) / rt.totalMemory()) * 100 )) > b) flg=true;
                        //String.format("%.2f", ((a.doubleValue() / b.doubleValue()) * 100))+"%";
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    public static void main(String[] args) {
//        Runtime rt = Runtime.getRuntime();
//        System.out.println("处理器总个数" + rt.availableProcessors());
//        System.out.println("Jvm总内存数" + rt.totalMemory()+"byte");
//        System.out.println("JVM空闲内存" + rt.freeMemory()+"byte");
//        System.out.println("JVM可调用的最大内存" + rt.maxMemory()+"byte");

        //Thread();
        System.out.println( 13 & 17);
    }
}





