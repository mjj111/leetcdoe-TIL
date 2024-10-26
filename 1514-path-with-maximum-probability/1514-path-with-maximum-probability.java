import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // 그래프를 인접 리스트로 구성 (node -> [(neighbor, probability)])
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            double prob = succProb[i];
            graph.get(a).add(new Node(b, prob));
            graph.get(b).add(new Node(a, prob));
        }

        double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0);
        maxProb[start] = 1.0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 1.0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int node = current.index;
            double prob = current.probability;

            if (node == end) {
                return prob;
            }

            for (Node neighbor : graph.get(node)) {
                double newProb = prob * neighbor.probability;

                if (newProb > maxProb[neighbor.index]) {
                    maxProb[neighbor.index] = newProb;
                    pq.offer(new Node(neighbor.index, newProb));
                }
            }
        }

        return 0.0;
    }

    private static class Node implements Comparable<Node>{
        int index;
        double probability;

        Node(int index, double probability) {
            this.index = index;
            this.probability = probability;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(other.probability, this.probability); // 내림차순 정렬
        }
    }
}
