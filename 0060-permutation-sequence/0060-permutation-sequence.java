class Solution {
    String answer = "";
    int K;
    int N;
    
    public String getPermutation(int n, int k) {
        N = n;
        K = k;
        findPermutations(new StringBuilder(), new boolean[N + 1]);
        return answer;
    }
    
    private void findPermutations(StringBuilder sb, boolean[] visited) {
        if (sb.length() == N) {
            K--;
            if (K == 0) {
                answer = sb.toString();
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                sb.append(i);
                visited[i] = true;
                
                findPermutations(sb, visited);

                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
