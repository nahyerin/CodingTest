import java.util.*;

class Solution {
    int ans = Integer.MAX_VALUE;
    boolean[] visited_order;
    List<String> orders;
    int[] cards;
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    
    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        // 남은 카드를 모두 제거하는데 필요한 키 조작 횟수의 최솟값
        
        int cnt = 0;
        for(int[] b:board){
            for(int i=0; i<4; i++){
                if(b[i]!=0){
                    cnt++;
                }
            }
        }
                
        cnt /= 2;
        
        int[] card = new int[cnt];
        for(int i=0; i<cnt; i++) {
	        card[i] = i+1;
        }

		orders = new ArrayList<>();
		dfs("", 0, card);
        
        //visited_order = new boolean[cnt+1];
        //dfs(cnt, 1, new int[cnt+1], board, r, c);
        
        for(String comb : orders) {
			String[] order = comb.split("");
        
            ans = Math.min(ans, getCount(order, cnt, board, r, c));
        }
        
        answer = ans;
        
        return answer;
    }
    
    //카드를 어떤 순서로 뒤집을 지 순열 구하기
    public void dfs(String comb, int depth, int[] card) {
		if(card.length == depth) {
			orders.add(comb);
			return;
		}
		
		for(int i=0; i<card.length; i++) {
			int num = card[i];
			if(!comb.contains(""+num)) {
				dfs(comb+num, depth+1, card);
			}
		}
		
	}
    
//     //카드를 어떤 순서로 뒤집을 지 순열 구하기
//     public void dfs(int n, int idx, int[] arr, int[][] board, int r, int c){
//         if(idx==n){
//             ans = Math.min(ans, getCount(arr, n, board, r, c));
//             return;
//         }
        
//         for(int i=1; i<=n; i++){
//             if(visited_order[i]) continue;
//             visited_order[i] = true;
//             arr[idx] = i;
            
//             dfs(n, idx+1, arr, board, r, c);
            
//             visited_order[i] = false;
//             arr[idx] = 0;
//         }
//     }
    
    public int getCount(String[] order, int n, int[][] board, int r, int c){
        int move_count = 0;
        
        int[][] copy_board = new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                copy_board[i][j] = board[i][j];
            }
        }
        
        int[] pos = new int[2];
        pos[0] = r;
        pos[1] = c;
        
        //순열 순서대로 이동시키기
         for(String o : order) {
		    int target = Integer.parseInt(o);
            
            move_count += bfs(target, copy_board, pos);
            copy_board[pos[0]][pos[1]] = 0; //방문 처리
            move_count++; //enter
            
            move_count += bfs(target, copy_board, pos);
            copy_board[pos[0]][pos[1]] = 0;
            move_count++; //enter
        }
        
        return move_count;
    }
    
    //2. 키 조작 횟수 구하기 
    public int bfs(int target, int[][] board, int[] pos){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(pos[0], pos[1], 0));
        boolean[][] visited = new boolean[4][4];
        visited[pos[0]][pos[1]] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            //target에 도착
            if(board[p.r][p.c]==target){
                pos[0] = p.r;
                pos[1] = p.c; //현재 위치 갱신
                return p.dis;
            }
            
            //상하좌우 한칸씩 이동
            for(int i=0; i<4; i++){
                int nr = p.r+dr[i];
                int nc = p.c+dc[i];
                
                if(nr<0 || nc<0 || nr>=4 || nc>=4 || visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                q.add(new Point(nr, nc, p.dis+1));
            }
            
            //ctrl + 방향키 이동
            for(int i=0; i<4; i++){
                Point pp = existsInRoute(p.r, p.c, i, board);
                if(visited[pp.r][pp.c] || (pp.r==p.r && pp.c==p.c)) continue;
                visited[pp.r][pp.c] = true;
                q.add(new Point(pp.r, pp.c, p.dis+1));
            }
        }
        
        return 0;
    }
    
    public Point existsInRoute(int r, int c, int dir, int[][] board){
        //누른 키 방향에 있는 가장 가까운 카드로 한번에 이동
        
        r += dr[dir];
        c += dc[dir];
        while(r<4 && c<4 && r>=0 && c>=0){
            if(board[r][c]!=0){
                return new Point(r, c, 0);
            }
            
            r += dr[dir];
            c += dc[dir];
        }
        
        //카드가 없다면 맨 끝으로 이동
        return new Point(r-dr[dir], c-dc[dir], 0);
        
    }
    
    class Point{
        int r, c, dis;
        Point(int r, int c, int dis){
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }
}