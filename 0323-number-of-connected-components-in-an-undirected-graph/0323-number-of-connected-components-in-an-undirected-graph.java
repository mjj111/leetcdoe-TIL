class Solution {
    private static boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Node> nodes = new HashMap<>();
        for(int i = 0; i < n; i++) {
            nodes.put(i, new Node(i));
        }
        visited = new boolean[n];

        for(int[] edge : edges) {
            Node start = nodes.get(edge[0]);
            Node end = nodes.get(edge[1]);

            start.addNode(end);
            end.addNode(start);
        }
        int answer = 0;
        for(Node now : nodes.values()) {
            if(!visited[now.id]) {
                answer +=1;
                dfs(now);
            }
        }
        return answer;

    }

    private static void dfs(Node now) {
        if(visited[now.id]) return;
        visited[now.id] = true;
        for(Node next : now.nexts){
            if(visited[next.id]) continue;
            dfs(next);
        } 
    }

    private static class Node {
        int id;
        List<Node> nexts = new ArrayList<>();
        
        public void addNode(Node n) {
            nexts.add(n);
        }
        public Node(int id) {
            this.id = id;
        }
    }
}