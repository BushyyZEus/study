package com.example.leetpractice.recall;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//给定数组和目标值，求等于目标值的所有组合，元素可以重复
//符合要求的解，只能出现一次
//递归求和时，可以用目标值在遍历中减，更好理解
//也可以用递归中加和等于目标值
public class lc39 {
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        int target = 7;
        List<List<Integer>> result = combinationSum(nums,target);
        System.out.println(result);
    }
    //由于[2,2,3]和[2,3,2]属于同一个答案，所以要考虑重复
    //重复分析
    //遍历时，一个根节点下面的节点（同层节点），第二个节点搜索时不能考虑前一个节点


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //长度的作用，用来输出空，控制递归遍历长度
        int len = candidates.length;
        //结果容器
        List<List<Integer>> res = new ArrayList<>();
        //输出空
        if (len == 0) {
            return res;
        }
        //队列用来控制当前搜索的状态（当前层结果），状态重置


        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点，递归中控制搜索起点控制指针
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    //这里通过目标值递减到0的方法
    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        //target为0时返回结果
        //用new ArrayList来拷贝获得数据，直接引用会得到空
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        //这里不使用used，使用begin，则在循环中不考虑跳过前一元素，规避重复问题

        //used和begin的使用区别
        //考虑顺序对结果的影响，如果结果顺序不影响最后结果，即相同元素的顺序不同可以为不同答案时
        //排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；

        //如果不考虑顺序，只考虑结果中有什么元素
        //组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。

        //used状态重置后仍能遍历的前面的元素
        //begin则直接截断数组，得不到前面的元素



        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            //全排列中只需要遍历即可
            //这里用target,控制进程
            //i控制不同的起始点
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }



    //剪枝提速prune

    //回溯中的剪枝
    //小于0之后不需要在遍历，提高搜索速度

    //注意点：数组排序，当出现小于0的情况直接break循环，因为不需要考虑循环中后面的元素

    public List<List<Integer>> combinationSumPrune(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);


        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfsPrune(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        //不考虑target<0
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
