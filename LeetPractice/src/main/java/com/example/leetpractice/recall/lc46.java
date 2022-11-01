package com.example.leetpractice.recall;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//全排列，把数组的所有排列组合列出
public class lc46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> permute(int[] nums) {
        //用长度控制
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        // 做题时首先创建结果容器
        List<List<Integer>> res = new ArrayList<>();
        //如果输入空直接返回
        if (len == 0) {
            return res;
        }
        //用布尔数组标识元素是否被选择过
        boolean[] used = new boolean[len];
        //用队列控制回溯状态和用来返回最后结果
        Deque<Integer> path = new ArrayDeque<>(len);
        //回溯函数所需元素

        //用来被递归的数组
        //用来控制边界的元素
        //用来标识进程进度的元素，搜索起点
        //队列
        //返回最后的结果

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        //递归结束条件
        //depth不断增加，增加到等于长度时则行进到末尾，无后续元素，停止
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                //假如第一次dfs的第一次循环加入1，第一次循环中的递归循环由于used已经为true,所以跳过1加入2
                path.addLast(nums[i]);
                used[i] = true;

//                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);
                //还原当前元素，最外层for循环到这里时，重置了所有元素为false
                //进入由2开始的循环时，因为1为false,就能实现2开头1放在2后面
                //排列次序，由两个元素协作控制，开头元素和used互相作用
                used[i] = false;
                //状态重置
                path.removeLast();
//                System.out.println("递归之后 => " + path);
//                System.out.println(Arrays.toString(used));
            }
        }
    }


}
