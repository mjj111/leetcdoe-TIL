class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        Set<Integer> keys = new HashSet<>();
        keys.add(0);
        boolean[] visited = new boolean[N];

        Queue<Integer> gonnaGoRooms = new LinkedList<>();
        gonnaGoRooms.add(0);

        while(!gonnaGoRooms.isEmpty()) {
            int nowRoomKey = gonnaGoRooms.poll();
            
            if(visited[nowRoomKey]) continue;
            
            visited[nowRoomKey] = true;

            List<Integer> roomKeys = rooms.get(nowRoomKey);
            for(int key : roomKeys) {
                gonnaGoRooms.add(key);
            }
        }

        for(boolean vis : visited) {
            if(!vis) return false;
        }
        return true;
    }
}