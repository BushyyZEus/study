package com.example.leetpractice.binary;

import com.example.leetpractice.binaryTree.TreeNode;
import com.example.leetpractice.sort.MergeSort;
import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class practice {

  public static List<List<Integer>> levelSort(TreeNode root){
    List<List<Integer>> ret = new ArrayList<>();

    if(root == null){
        return ret;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
        List<Integer> level = new ArrayList<>();
        int currentSize = queue.size();
        for (int i = 0; i < currentSize; i++) {
            TreeNode tree = queue.poll();
            if(tree.left != null){
                queue.offer(tree.left);
            }
            if(tree.right != null){
                queue.offer(tree.right);
            }
            level.add(tree.val);
        }
        ret.add(level);
    }
    return ret;
  }
}
