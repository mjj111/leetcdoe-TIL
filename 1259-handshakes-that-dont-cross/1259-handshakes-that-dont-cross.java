class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] memo;

    public int numberOfWays(int numPeople) {
        memo = new long[numPeople + 1];
        return (int) calculateWays(numPeople);
    }

    private long calculateWays(int n) {
        if (n == 0 || n == 2) {
            return 1; 
        }
        
        if (memo[n] != 0) {
            return memo[n]; 
        }

        long ways = 0;
        for (int i = 0; i < n; i += 2) {
            ways = (ways + (calculateWays(i) * calculateWays(n - 2 - i)) % MOD) % MOD;
        }
        return memo[n] = ways;
    }
}