class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, graph, new HashSet<>(), visited);
    }
    
    private boolean dfs(int node, int destination, Map<Integer, List<Integer>> graph, Set<Integer> seen, boolean[] visited) {
        //리프노드 확인
        if (!graph.containsKey(node)) {
            return node == destination;
        }

        // 루프 확인
        if (seen.contains(node)) {
            return false; 
        }

        seen.add(node);
        for (int child : graph.get(node)) {
            if(visited[child]) continue;
            if (!dfs(child, destination, graph, seen, visited)) {
                return false;
            }
        }
        seen.remove(node);
        visited[node] = true;

        return true;
    }
}