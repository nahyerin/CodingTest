public class Solution {
	static int answer;
	static boolean[] visited;
	static String[] arr = {"A","C","F","J","M","N","R","T"};
	
	public static int solution(int n, String[] data) {
		answer = 0;
		visited = new boolean[8];
		
		dfs(0,"",data);
		return answer;
	}
	
	private static void dfs(int idx, String names,String[] data){
		if(idx == 8){
			if(check(names,data)) {
				answer += 1;
			}
			return;
		}
		
		for(int i = 0; i< 8; i++){
			if(!visited[i]){
				visited[i] = true;
				String name = names + arr[i];
				dfs(idx + 1,name,data);
				visited[i] = false;
			}
		}
	}
	
	private static boolean check(String name,String[] data){
		for(String str : data){
			int pos1 = name.indexOf(str.charAt(0));
			int pos2 = name.indexOf(str.charAt(2));
			
			char logic = str.charAt(3);
			int standard = str.charAt(4) - '0';
			
			switch (logic){
				case '=' :
					if(!(Math.abs(pos1 - pos2) == standard + 1)){
						return false;
					}
					break;
				case '>' :
					if(!(Math.abs(pos1 - pos2) > standard + 1)){
						return false;
					}
					break;
				case '<' :
					if(!(Math.abs(pos1 - pos2) < standard + 1)){
						return false;
					}
					break;
			}
		}
		return true;
	}
}