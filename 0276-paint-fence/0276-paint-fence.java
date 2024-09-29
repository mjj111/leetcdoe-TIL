class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private static int k;
    public int numWays(int n, int k) {
        this.k = k;
        return totalWays(n);
    }

    private int totalWays(int i) {
        if (i == 1) return k;
        if (i == 2) return k * k;
        
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        memo.put(i, (k - 1) * (totalWays(i - 1) + totalWays(i - 2)));
        return memo.get(i);
    }
}