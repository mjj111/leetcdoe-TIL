class Solution {
    private static int[][] costs;
    private static int[][] dp;
    private static int k;
    public int minCostII(int[][] costs) {
        this.costs = costs;
        k = costs[0].length;
        dp = new int[costs.length][k];

        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            minValue = Math.min(minValue, paint(costs.length - 1, i));
        }

        return minValue;
    }

    private static int paint(int n, int color) {
        if(n==0) {
            return costs[0][color];
        }

        if(dp[n][color] != 0) {
            return dp[n][color];
        }

        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            if(i == color) continue;
            minValue = Math.min(minValue, costs[n][color] + paint(n-1, i));
        }
        
        return dp[n][color] = minValue; 
    }
}