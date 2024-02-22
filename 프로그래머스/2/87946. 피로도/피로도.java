import java.util.*;
//DFS를 이용한 완전탐색
class Solution {
    static int answer = 0;
    static boolean[] visited;
    //주어진 던전의 개수만큼 -> 현재 피로도에서 가능한 던전들을 완전탐색
    public int solution(int k, int[][] dungeons) {      
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    //visited-> 방문 처리(이미 방문한 곳은 다시 방문하지 않도록)
    public void dfs(int cnt, int fatigue, int[][] dg) {
        for(int i = 0; i < dg.length; i++){
            if(visited[i] || dg[i][0] > fatigue) continue;
            visited[i] = true;
            dfs(cnt+1, fatigue-dg[i][1], dg);
            visited[i] = false;
        }
        //가능한 최대 던전 수를 구하기
        answer = Math.max(cnt, answer);
    }
}
