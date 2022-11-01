package com.example.leetpractice.sort;

import java.util.Arrays;

public class QuickSort{
    public static void main(String[] args) {
        int[] nums={5,4,3,7};
        System.out.println("快速排序前:"+ Arrays.toString(nums));
        quickSort(nums,0,nums.length-1);
        System.out.println("快速排序后:"+ Arrays.toString(nums));
    }

    public static void quickSort(int[] nums,int start,int end){
        int i,j,base;
        i = start;
        j = end;
        base = nums[start];
        //start和end相等时，代表已经无法进行后续交换了，直接返回
        if(start>=end){return;}
        //相当与当i=j时，结束，两个指针相遇，即应进入下一次，两头数组的排序
        while(i<j){
            //移动右节点，这里必须先j--,必须先移动右节点
            while(i<j && nums[j]>=base){
                j--;
            }
            //移动左节点
            while(i<j && nums[i] <= base){
                i++;
            }
            //两个节点固定位置后，如果i在j的左边，那么交换左右节点的位置
            //如果i>j,说明进行了多余的运算，不交换位置
            if(i<j){
                swap(nums,i,j);
            }
        }
//        交换哨兵的位置到中间空位，换到i或j都可以，因为到这里的时候i和j相遇相等
        swap(nums,start,i);
        quickSort(nums,start,j-1);
        quickSort(nums,j+1,end);
    }
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}





//public class QuickSort {
//    public static void main(String[] args) {
//        int[] nums={5,4,3,7};
//        System.out.println("快速排序前:"+ Arrays.toString(nums));
//        quickSort(nums,0,nums.length-1);
//        System.out.println("快速排序后:"+ Arrays.toString(nums));
//    }
//    public static void quickSort(int[] nums, int start, int end){
//        if(start>end) return;
//        int i,j,base;
//        i=start;
//        j=end;
//        base=nums[start];
//        while (i<j){
//            while (i<j && nums[j]>=base) j--;
//            while (i<j && nums[i]<=base) i++;
//            if(i<j){
//                swap(nums,i,j);
//            }
//        }
//        swap(nums,start,i);
//        quickSort(nums,start,j-1);
//        quickSort(nums,j+1,end);
//    }
//    public static void swap(int[] nums,int left,int right){
//        int temp=nums[left];
//        nums[left]=nums[right];
//        nums[right]=temp;
//    }
//
//}
