class Solution {
    private static int N, M;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        N = maze.length;
        M = maze[0].length;

        boolean[][] visited = new boolean[N][M];
        visited[start[0]][start[1]] = true; 

        Deque<int[]> dq = new LinkedList<>();
        dq.addLast(start);

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
    
        while(!dq.isEmpty()) {
            int[] now = dq.removeFirst();
            if(now[0] == destination[0] && now[1] == destination[1]) return true;
            //23일 6시 시험 
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while(isIn(nx, ny) && maze[nx][ny] == 0) {
                    nx += dx[i];
                    ny += dy[i]; 
                }

                nx -= dx[i];
                ny -= dy[i];

                if(visited[nx][ny]) continue;
                dq.addLast(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        return false;
    }
    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}