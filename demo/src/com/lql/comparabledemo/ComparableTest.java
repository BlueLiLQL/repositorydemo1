package com.lql.comparabledemo;

import java.util.Arrays;

public class ComparableTest {

    public static void main(String[] args) {


        //Arrays api 的基本使用
        int[] nums = {12,32,435,546,43,2,46};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));


        String[] names = {"啥","dhs","到那时","嗯嗯","其实","我","很好"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));


        //对象的比较，需要实现Comparable接口
        People[] peoples = {new People("lql",21,"男"), new People("你好",22,"男"),
                new People("你真好",23,"男"),new People("我也好",25,"男"),
                new People("你真的好",24,"男"),new People("大家好",26,"男")
        };
        Arrays.sort(peoples);
        System.out.println(Arrays.toString(peoples));

        //使用Comparato
        Arrays.sort(peoples,new PeopleComparator());
        System.out.println(Arrays.toString(peoples));

    }
}
