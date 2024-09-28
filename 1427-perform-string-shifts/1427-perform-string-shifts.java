class Solution {
    private static int LEFT = 0;
    private static int RIGHT = 1;
    public String stringShift(String s, int[][] shift) {
        Deque<Character> dq = new LinkedList<>();
        for(char c : s.toCharArray()) {
            dq.addLast(c);
        }

        for(int[] order : shift) {
            int direction = order[0];
            int amount = order[1];

            while(amount-- > 0) {
                if(direction == LEFT) {
                    char tmp = dq.removeFirst();
                    dq.addLast(tmp);
                }
                else if(direction == RIGHT) {
                    char tmp = dq.removeLast();
                    dq.addFirst(tmp);
                } 
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            sb.append(dq.removeFirst());
        }
        return sb.toString();
    }
}