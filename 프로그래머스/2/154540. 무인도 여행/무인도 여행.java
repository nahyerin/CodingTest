import java.util.*;

class Point{
    int x;
    int y;
    Point(int a, int b){
        x = a;
        y = b;
    }
}

class Solution {
    int N, M;
    boolean[][] visit;
    List<Integer> list;
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visit = new boolean[N][M];
        list = new ArrayList();
        
        for(int i = 0 ; i < N; ++i){
            for(int j = 0 ; j < M; ++j){
                // 해당 지점에 음식이 있고, 방문한적이 없다면 탐색을 시작한다.
                if(hasFood(maps[i].charAt(j)) && !visit[i][j]){
                    list.add(search(maps, i, j));
                }
            }
        }
        
        // 조건에 따라, 무인도가 없는 경우 -1
        if(list.isEmpty())
            list.add(-1);
        
        // 오름차순으로 정렬
        return list.stream()
                .sorted()
                .mapToInt(i->i)
                .toArray();
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    // 해당 지점에서 탐색하여 머물 수 있는 최대 일 수를 반환.
    public int search(String[] maps, int startX, int startY){
        int result = 0;
        result += maps[startX].charAt(startY)-'0';
        visit[startX][startY] = true;
        Queue<Point> q = new ArrayDeque();
        q.add(new Point(startX, startY));
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            // 인접 지역으로 탐색
            for(int d = 0 ; d < 4; ++d){
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];
                // 범위 내부면서, 음식이 있고, 방문한적이 없다면 해당 지점에서 탐색
                if(isInRange(nextX, nextY) && hasFood(maps[nextX].charAt(nextY)) && !visit[nextX][nextY]){
                    visit[nextX][nextY] = true;
                    result += maps[nextX].charAt(nextY)-'0';
                    q.add(new Point(nextX, nextY));
                }
            }
        }
        return result;
    }
    
    public boolean hasFood(char c){
        if('0'<= c  && c <='9')
            return true;
        return false;
    }
    
    public boolean isInRange(int x, int y){
        if(0 <= x && x < N && 0 <= y && y <M)
            return true;
        return false;
    }
}