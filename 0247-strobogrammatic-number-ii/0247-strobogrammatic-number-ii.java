import java.util.*;

class Solution {
    private char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        
        for (String s : list) {
            for (char[] pair : pairs) {
                if (n != m || pair[0] != '0') {
                    res.add(pair[0] + s + pair[1]);
                }
            }
        }
        
        return res;
    }
}