package com.lql.sortdemo;

import java.util.Arrays;

/**
 * 插入排序算法
 * （从后向前找到合适的位置插入）
 * 基本思想：每步将一个待排序的记录，按器顺序码大小插入到前面已经排序的序列的合适位置
 * （从后向前找到合适位置后），直到全部插入排序位置
 */
public class InsertSortTest {

    public static void main(String[] args) {
        int[] nums ={1,23,44,11,33,2,4,6,19,43};
        for (int i = 1,j,current; i < nums.length ; i++) {
            current = nums[i];
            //if(i-1 > 0 ) System.out.println("i-1=" + (i-1));
            for ( j = i - 1; j > 0 &&  nums[j] > current ; j --) {

                nums[j+1] = nums[j];
            }
            nums[j+1] = current;
        }

        System.out.println(Arrays.toString(nums));
    }
}
