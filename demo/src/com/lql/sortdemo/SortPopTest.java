package com.lql.sortdemo;

import java.util.Arrays;

/**
 * 1、冒泡排序算法
 * 运作如下：（从后往前）
 * 比较相邻的两个元素。如果第一个比第二个大，就交换他们两个
 * 比较相邻元素之间的工作，从开始第一队到结尾最后一对。在这一点，最后的元素应该会是最大的数
 * 针对所有元素重复以上的步骤，除了最后一个
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
 * 相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法
 */
public class SortPopTest {

    public static void main(String[] args) {

        int[] nums ={1,23,44,11,33,2,4,6,19,43};
        //int[] nums ={23,44,11,6,19,43};
        int[] temps = new int[nums.length];
        int temp = 0;
        Boolean finsh = false;
        for (int i = 0; i < nums.length - 1 ; i++) {
            for (int j = 0; j < temps.length - 1 -i  ; j++) {  //因为每次排序之后最后一位都是最大的数，所以是循环的长度就是length -1 -i
                if(nums[j] > nums[j+1]){
                    temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));

    }


    /*public static void sortNums(int[] arrys){
        boolean hasChange = true;
        for (int i = 0; i <arrys.length -1 && hasChange ; i++) {
            hasChange =false;
            for (int j = 0; j < arrys.length -1 -i ; j++) {
             交换成功后把haschange赋值为true
             否则haschange为false，不进行下次循环
            }
        }
    }*/
}
