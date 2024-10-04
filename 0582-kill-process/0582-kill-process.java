class Solution {
    public List<Integer> killProcess(List<Integer> nodeIds, List<Integer> parentIds, int kill) {
        Map<Integer, Node> nodes = new HashMap<>();
        for(int id : nodeIds){
            nodes.put(id, new Node(id));
        }
        nodes.put(0, new Node(0));

        for(int i = 0; i < nodeIds.size(); i++) {
            Node child = nodes.get(nodeIds.get(i));
            Node parent = nodes.get(parentIds.get(i));

            child.parent = parent;
            parent.putChild(child);
        }

        Node target = nodes.get(kill);
        List<Integer> answer = new ArrayList<>();
        
        Deque<Node> dq = new LinkedList<>();
        dq.addLast(target);

        while(!dq.isEmpty()) {
            Node now = dq.removeFirst();
            answer.add(now.id);
            for(Node next : now.children) {
                dq.addLast(next);
            }
        }

        return answer;

    }
    private static class Node {
        int id;
        Node parent;
        List<Node> children = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }
        public void putChild(Node child) {
            children.add(child);
        }
    }
}