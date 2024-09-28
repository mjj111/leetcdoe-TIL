class Solution {
    public void reverseWords(char[] s) {
        StringBuilder sb = new StringBuilder();
        Deque<String> dq= new LinkedList<>();
        for(char c : s) {
            if(c ==' ') {
                dq.addLast(sb.toString());
                sb.setLength(0);
                continue;
            }

            sb.append(c); 
        }
        dq.addLast(sb.toString());
        int sIndex = 0;
        List<Character> answer = new ArrayList<>();
        while(!dq.isEmpty()) {
            String now = dq.removeLast();
            for(char c : now.toCharArray()) {
                s[sIndex] = c ;
                sIndex++;
            }
            if(dq.isEmpty()) {
                break;
            }
            s[sIndex] = ' ';
            sIndex++;
        }
    }
}