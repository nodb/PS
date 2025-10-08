class Solution {
    static int users[][];
    static int emoticons[];
    static int n;
	static int arr[];
	static int rates[] = { 10, 20, 30, 40 };
	static int maxCheck = 0;
	static int maxPrice = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
		n = emoticons.length;
		arr = new int[n];
		dfs(0);
        return new int[] {maxCheck, maxPrice};
    }
    
    	public static void dfs(int i) {
		if (i == n) {
			evaluate();
			return;
		}

		for (int r : rates) {
			arr[i] = r;
			dfs(i + 1);
		}
	}

	public static void evaluate() {
		int totalCheck = 0;
		int totalPrice = 0;
		
		for (int i = 0; i < users.length; i++) {
			int price = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] >= users[i][0]) {
					price += emoticons[j] * (100 - arr[j]) / 100;
				}
			}
			if (price >= users[i][1])
				totalCheck++;
			else
				totalPrice += price;
		}
		if (totalCheck > maxCheck) {
			maxCheck = totalCheck;
			maxPrice = totalPrice;
		} else if (totalCheck == maxCheck && totalPrice > maxPrice) {
			maxCheck = totalCheck;
			maxPrice = totalPrice;
		}
	}
}