import java.io.*;
import java.util.*;


class Solution {
    
    List<List<Integer>> graph = new ArrayList<>();
    public int dfs(int sheep, int wolf, int curNode, List<Integer> nextNodes, int[] info){
        if(info[curNode] == 0) sheep++;
        else wolf++;
        
        int ans = sheep;
        if(sheep <= wolf) return ans;
        for(int i=0;i<nextNodes.size();i++){
            int nextNode = nextNodes.get(i);
            List<Integer> stackNodes = new ArrayList<>(nextNodes);
            stackNodes.remove((Integer)nextNode); // 본인을 방문하면 안됨
            stackNodes.addAll(graph.get(nextNode));
            ans = Math.max(ans, dfs(sheep, wolf, nextNode, stackNodes, info));
        }
        
        
        return ans;
    }
    
    
    public int solution(int[] info, int[][] edges) {
        int nodeLength = info.length;
        for(int i=0;i<nodeLength;i++){
            graph.add(new ArrayList<>());
        }
        
        int edgeLength = edges.length;
        for(int i=0;i<edgeLength;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        
        List<Integer> nextNodes = new ArrayList<>();
        for(int i=0;i<graph.get(0).size();i++)
            nextNodes.add(graph.get(0).get(i));
        return dfs(0, 0, 0, nextNodes,info);
    }
}