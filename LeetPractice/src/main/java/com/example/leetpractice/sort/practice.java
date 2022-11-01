package com.example.leetpractice.sort;



import com.example.leetpractice.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class practice {
    public List<List<Integer>> levelSort(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return ret;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                TreeNode tree = queue.poll();
                levelList.add(tree.val);
                if(tree.left != null){
                    queue.offer(tree.left);
                }
                if(tree.right != null){
                    queue.offer(tree.left);
                }
            }
            ret.add(levelList);
        }
        return ret;
    }
}
//   public static List<List<Integer>> levelSort(TreeNode root){
//       List<List<Integer>> ret = new ArrayList<>();
//       if(root == null){
//           return ret;
//       }
//       Queue<TreeNode> queue = new LinkedList<>();
//       queue.offer(root);
//       while(!queue.isEmpty()){
//           List<Integer> level = new ArrayList<Integer>();
//           int currentLevelSize = queue.size();
//           for (int i = 1; i <= currentLevelSize; ++i) {
//               TreeNode node = queue.poll();
//               level.add(node.val);
//               if (node.left != null) {
//                   queue.offer(node.left);
//               }
//               if (node.right != null) {
//                   queue.offer(node.right);
//               }
//           }
//           //最后给二维数组添加level数组，即一整层
//           ret.add(level);
//       }
//       return ret;
//   }