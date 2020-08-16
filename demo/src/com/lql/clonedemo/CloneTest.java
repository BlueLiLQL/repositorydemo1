package com.lql.clonedemo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class CloneTest {

    public static void main(String[] args) {

        People LBW = new People("卢本伟",26,"男");
        try {
            People five = (People)LBW.clone();
            System.out.println(LBW.toString());
            System.out.println(five.toString());
            System.out.println(LBW == five);
            System.out.println(LBW.equals(five));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try (OutputStream out = new FileOutputStream(new File(""))) {
        }catch (Exception e){

        }


    }
}
