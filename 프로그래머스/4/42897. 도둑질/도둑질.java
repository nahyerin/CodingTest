class Solution {
    public int solution(int[] money) {
        int[] dpO = new int[money.length]; //첫집O
        int[] dpX = new int[money.length]; //첫집X
        int len = money.length;

        dpO[0] = money[0];
        dpO[1] = money[0];

        dpX[0] = 0;
        dpX[1] = money[1];

        for (int i = 2; i < len; i++) {
			//현재 집을 털지 않는 경우 vs 현재 집을 터는 경우
            dpO[i] = Math.max(dpO[i - 1], money[i] + dpO[i - 2]);
            dpX[i] = Math.max(dpX[i - 1], money[i] + dpX[i - 2]);
        }

		//첫집을 터는 경우, 못터니까 dpO[len-2]까지만 가능하다
        return Math.max(dpO[len - 2], dpX[len - 1]);
    }
}