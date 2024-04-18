import java.util.ArrayList;
import java.util.PriorityQueue;
class Solution {
    class Node implements Comparable<Node>{

		int town; // 마을 번호
		int cost; // 이동 시간
		
		public Node (int town, int cost) {
			this.town = town;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost > o.cost ? 1 : -1;
		}

		@Override
		public String toString() {
			return "Node [town=" + town + ", cost=" + cost + "]";
		}
		
	}
	
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N+1; i++) { 
        // 마을 번호가 1부터 시작하기 때문에 N+1개 만큼 add하여
        // 마을 번호를 index처럼 활용
			map.add(new ArrayList<Node>());
		}
        
        for (int i = 0; i < road.length; i++) {
            // 주어지는 도로 정보를 새 Node를 생성하여
            // 마을 번호 index에 해당하는 ArrayList에 add
            // 이어지는 두 마을 모두에 저장
			map.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
			map.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
		}
        
        // 방문 여부
        boolean[] visited = new boolean[N+1];
        // 최소 비용
        int[] min_cost = new int[N+1];
        for (int i = 0; i < min_cost.length; i++) {
			min_cost[i] = Integer.MAX_VALUE;
		}
        min_cost[1] = 0;
        
        // 다익스트라 알고리즘
        for (int i = 0; i < N; i++) {
			// 방문하지 않은 노드 중 가장 비용이 작은 노드
        	Node target = find_min_cost(visited, min_cost);
			visited[target.town] = true;
			
			// 인접 노드로의 최소 비용
			ArrayList<Node> around = map.get(target.town);
			for (int j = 0; j < around.size(); j++) {
				if (min_cost[around.get(j).town] > around.get(j).cost + target.cost) {
					min_cost[around.get(j).town] = around.get(j).cost + target.cost;
				}
			}
		}
        
        // 최소 비용이 K 이하인 마을 count
        for (int i = 1; i < min_cost.length; i++) {
			if (min_cost[i] <= K)
				answer++;
		}
        
        return answer;
    }
    private Node find_min_cost(boolean[] visited, int[] min_cost) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	for (int i = 1; i < min_cost.length; i++) {
			if (!visited[i]) { 
            	// 방문하지 않은 마을의 최소 비용을
                // PriorityQueue에 add
				pq.add(new Node(i, min_cost[i]));
			}
		}
    	return pq.peek(); // 최소 비용이 가장 작은 Node를 return
    }
}