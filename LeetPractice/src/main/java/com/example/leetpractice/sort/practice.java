package com.example.leetpractice.sort;



import com.example.leetpractice.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class practice {
    public static void main(String[] args) {
        int[] arr = {4,2,1,5,9};
        quickSort(arr, 0, arr.length-1);
        System.out.print(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int start,int end){
        int i = start;
        int j = end;
        int base = arr[start];
        if(start>=end){
            return;
        }
        while(i<j){
            while(i<j && arr[j]>=base){
                j--;
            }
            while(i<j && arr[i]<=base){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,start,j);
        quickSort(arr,start,j-1);
        quickSort(arr,j+1,end);
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
