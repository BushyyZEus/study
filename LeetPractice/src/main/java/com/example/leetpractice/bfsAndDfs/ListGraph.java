package com.example.leetpractice.bfsAndDfs;

import java.util.ArrayList;


//用链表实现有向图
//LinkedList,插入快，查询慢
//arrayList,插入慢，查询快   所以用arrayList来实现图
public class ListGraph {
    ArrayList<ArrayList<Integer>> graphs;

    public ListGraph(int v){
        graphs = new ArrayList<>();
        for(int i = 0;i<v;i++){
            graphs.add(new ArrayList<>());
        }
    }

    public void addEdge(int start,int end){
        graphs.get(start).add(end);
    }

    public void removeEdge(int start,int end){
        graphs.get(start).remove((Integer)end);
    }
}
