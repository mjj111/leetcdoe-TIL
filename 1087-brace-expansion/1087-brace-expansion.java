class Solution {
    private static List<String> answer;
    private static String S;
    private static int N;
    public String[] expand(String s) {
        S = s;
        N = s.length();

        answer = new ArrayList<>();
        find(new StringBuilder(), 0);
        Collections.sort(answer);
        String[] a = new String[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            a[i] = answer.get(i);
        }
        return a;
    }
    private void find(StringBuilder sb, int index) {
        if(index == N) {
            answer.add(sb.toString());
            return;
        }

        char now = S.charAt(index);
        if(now =='{') {
            int nextIndex = index + 1;
            char next = S.charAt(nextIndex);
            while(next !='}') next = S.charAt(++nextIndex);

            for(int i = index+1; i < nextIndex; i+= 2) {
                sb.append(S.charAt(i));
                int tmpSize = sb.length();

                find(sb, nextIndex+1);

                sb.setLength(tmpSize-1);
            }
        }
        else {
            sb.append(S.charAt(index));
            find(sb, index + 1);
        }
    }
}