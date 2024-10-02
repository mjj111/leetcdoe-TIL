import java.util.*;

class Solution {
    private static List<List<Integer>> result;
    public List<List<Integer>> getFactors(int n) {
        result = new ArrayList<>();        
        backtrack(n, 2, new ArrayList<>());
        return result;
    }

    private void backtrack(int n, int start, List<Integer> current) {
        if (n == 1) {
            if (current.size() > 1) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                current.add(i);
                backtrack(n / i, i, current);
                current.remove(current.size() - 1);
            }
        }
    }
}