class Solution {
    public int shortestWay(String source, String target) {
        Set<Character> setC = new HashSet<>();
        for(char c : source.toCharArray()) {
            setC.add(c);
        }
        
        int sourceIndex = 0;
        int answer = 1; 

        for(int targetIndex = 0; targetIndex < target.length(); targetIndex++) {
            char nowTarget = target.charAt(targetIndex);
            if(!setC.contains(nowTarget)) return -1;

            boolean found = false;
            while (!found) {
                if(sourceIndex == source.length()) {
                    answer++;
                    sourceIndex = 0;
                }

                if (source.charAt(sourceIndex) == nowTarget) {
                    found = true;
                }
                sourceIndex++;
            }
        }
        return answer;
    }
}