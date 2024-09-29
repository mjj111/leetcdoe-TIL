class Solution {
    private static int[][] costs;
    private static int[][] dp;
    public int minCost(int[][] costs) {
        this.costs = costs;
        dp = new int[costs.length][3];

        int minValue = paint(costs.length-1,0);
        minValue = Math.min(minValue, paint(costs.length-1,1));
        minValue = Math.min(minValue, paint(costs.length-1,2));
        
        return minValue;
    }

    private static int paint(int n, int color) {
        if(n==0) {
            return costs[0][color];
        }

        if(dp[n][color] != 0) {
            return dp[n][color];
        }

        int deferentColor1 = (color + 1) % 3;
        int deferentColor2 = (color + 2) % 3;
        dp[n][color] = Math.min(paint(n-1,deferentColor1), paint(n-1,deferentColor2)) + costs[n][color];
        
        return dp[n][color]; 
    }
}