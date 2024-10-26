class Solution {
    String findWord;
    int N;
    int M;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public boolean exist(char[][] board, String word) {
        N = board.length;
        M = board[0].length;
        findWord = word;

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == word.charAt(0) && findWord(i, j, visited, 0, board)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean findWord(int x, int y, boolean[][] visited, int depth, char[][] board) {
        if (!inRange(x, y) || visited[x][y] || board[x][y] != findWord.charAt(depth)) {
            return false;
        }
        
        if (depth == findWord.length() - 1) {
            return true;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (findWord(nextX, nextY, visited, depth + 1, board)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    public boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
