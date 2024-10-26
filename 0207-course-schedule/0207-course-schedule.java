class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> nexts = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            nexts.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] pres : prerequisites) {
            int now = pres[0];
            int pre = pres[1];

            nexts.get(pre).add(now);
            indegree[now]++;
        }

        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                dq.addLast(i);
                System.out.print(i+ " ");
            }
        }

        boolean[] visited = new boolean[numCourses];
        while(!dq.isEmpty()) {
            int now = dq.removeFirst();
            visited[now] = true;
            
            for(int next : nexts.get(now)) {
                indegree[next] -= 1;
                if(indegree[next] == 0) dq.addLast(next);
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
}