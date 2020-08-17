package com.lql.sortdemo;

import java.util.Arrays;

/**
 * 选择排序算法
 *每一次从待排序的数据元素中选择最小（或最大）的一个元素
 * 顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完
 * 选择排序是不稳定的排序算法
 */
public class SelectSortTest {
    public static void main(String[] args) {
        int[] nums ={1,23,44,11,33,2,4,6,19,43};
        //用于记录每次比较的最小值的下标
        int temp = 0;
        int minIndex = 0;
        for (int i = 0; i < nums.length - 1 ; i++) {
            //假设一个最小值下标
            minIndex = i;
            for (int j = i+1; j < nums.length   ; j++) {
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            //判断需要交换的数的下标是否是自己
            if(minIndex != i){
                temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
