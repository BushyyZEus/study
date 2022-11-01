package com.example.leetpractice.binary;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9};
        int target = 7;
        int result = binarySearch(arr,target);
        System.out.println(result);
    }



    public static int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]> target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
