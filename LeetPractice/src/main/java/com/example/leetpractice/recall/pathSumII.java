package com.example.leetpractice.recall;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import com.example.leetpractice.binaryTree.TreeNode;

public class pathSumII {


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
//        path.offerLast(root);
        dfs(ret,root,path, targetSum);
        return ret;
    }
    //root 开始点, 因为树，用左右节点控制前进，不需要像数组一样用used或begin控制
    //ret 结果容器
    //path 状态控制队列
    //targetSum 目标值
    public void dfs(List<List<Integer>> ret, TreeNode root, Deque<Integer> path, int targetSum){
        if(root == null){
            return;
        }
//        if(path.isEmpty()){
//            return;
//        }
        targetSum -= root.val;
        path.offerLast(root.val);
        if(targetSum == 0 && root.left == null && root.right == null){
            ret.add(new LinkedList<Integer>(path));
        }

        dfs(ret,root.left,path,targetSum);
        dfs(ret,root.right,path,targetSum);
//        状态重置
        path.pollLast();
    }
}
