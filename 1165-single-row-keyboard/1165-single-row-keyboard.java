class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> keyIndex = new HashMap<>();
        int i = 0;
        for(char c : keyboard.toCharArray()) {
            keyIndex.put(c, i++);
        }
        
        int now = 0;
        int move = 0;
        for(char c : word.toCharArray()) {
            int tmp = keyIndex.get(c);
            move += Math.abs(now - tmp);
            now = tmp; 
        }
        return move;
    }
}