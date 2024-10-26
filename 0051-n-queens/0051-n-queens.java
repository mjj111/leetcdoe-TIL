import java.util.*;

class Solution {
    int N;
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> solveNQueens(int t) {
        N = t;

        char[][] board = new char[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(board[i], '.');
        }
        
        findQueen(board, 0);

        return answer;
    }

    private void findQueen(char[][] board, int now) {
        if(now == N) {
            List<String> arrL = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                arrL.add(String.valueOf(board[i]));
            }

            answer.add(new ArrayList<>(arrL));
            return;
        }

        for(int j = 0; j < N; j++) {
            board[now][j] = 'Q';
            if(isCorrect(board, now)) {
                findQueen(board, now + 1);
            }
            board[now][j] = '.';
        }
    }

    private boolean isCorrect(char[][] board, int x) {
        for(int i = 0; i <= x; i++) {
            for(int j = 0; j < N; j++) {

                if(board[i][j] != 'Q') continue;

                for(int k = 1; k < N; k++) {
                    if(i + k < N) {
                        if(board[i+k][j] == 'Q') return false; // 세로 방향
                        if(j - k >= 0 && board[i + k][j - k] == 'Q') return false; // 좌 대각선
                        if(j + k < N && board[i + k][j + k] == 'Q') return false;  // 우 대각선
                    }
                }
            }
        }
        return true;
    }
}
