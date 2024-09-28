class Solution {
    List<Node>[] vertex;
    public int networkDelayTime(int[][] times, int n, int k) {
        vertex = new List[n+1];
        for(int i = 0; i < n+1; i++) {
            vertex[i] = new ArrayList<>();
        }
        
        for(int[] time : times) {
            int start = time[0];
            int end = time[1];
            int cost = time[2];
            vertex[start].add(new Node(end, cost));
        }
        
        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        dijkstra(k, distances);
        
        
        int answer = Integer.MIN_VALUE;
        for(int distance : distances) {
            if(distance == Integer.MAX_VALUE) return -1;
            answer = Math.max(answer, distance);
        }
        
        return answer;
    }
    
    private void dijkstra(int start, int[] distances) {
        Queue<Node> pq = new PriorityQueue<>();
        distances[start] = 0;
        for(Node next : vertex[start]) {
            pq.offer(next);
        }
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(now.cost >= distances[now.vertex]) continue;
            distances[now.vertex] = now.cost;
            
            for(Node next : vertex[now.vertex]) {
                if(distances[next.vertex] > next.cost + now.cost) {
                    pq.offer(new Node(next.vertex, next.cost + now.cost));
                }
            }
        }
        
    }
    
    class Node implements Comparable<Node> {
        int cost;
        int vertex;
        
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node op) {
            return this.cost - op.cost; // cost 오름차순
        }
    }
}