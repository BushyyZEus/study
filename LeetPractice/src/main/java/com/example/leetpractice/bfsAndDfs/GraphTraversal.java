package com.example.leetpractice.bfsAndDfs;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class GraphTraversal {
    ListGraph graph;
    boolean[] visited;

    public GraphTraversal(ListGraph listGraph){
        this.graph = listGraph;
        //这种创建方式，默认每个元素是false
        visited = new boolean[listGraph.graphs.size()];
    }
// 深度
    public void DFSTraversal(int v){
        if(visited[v]) return;
        visited[v] = true;
        System.out.println(v+"->");
        Iterator<Integer> neighbors = graph.graphs.get(v).listIterator();
        while(neighbors.hasNext()){
            int nextNode = neighbors.next();
            if(!visited[nextNode]){
                DFSTraversal(nextNode);
            }
        }
    }

    public void DFS(){
        for(int i = 0;i < graph.graphs.size();i++){
            if(!visited[i]){
                DFSTraversal(i);
            }
        }
    }
// 广度
    public void BFSTraversal(int v){
        Deque<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.offerFirst(v);
        while(queue.size()!=0){
            Integer cur = queue.pollFirst();
            System.out.println(cur+"->");
            Iterator<Integer> neighbors = graph.graphs.get(cur).listIterator();
            while(neighbors.hasNext()){
                int nextNode = neighbors.next();
                if(!visited[nextNode]){
                    queue.offerLast(nextNode);
                    visited[nextNode] = true;
                }
            }

        }
    }

    public void BFS(){
        for (int i = 0; i < graph.graphs.size(); i++) {
            if(!visited[i]){
                BFSTraversal(i);
            }
        }
    }
}
