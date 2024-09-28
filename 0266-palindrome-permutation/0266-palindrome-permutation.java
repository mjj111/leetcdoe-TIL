class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] charS = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c : charS) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        boolean findOne = false;
        for(int value : charMap.values()) {
            if(value % 2 == 0) continue; 

            if(value % 2 != 0 && !findOne) {
                findOne = true;
            }
            else {
                return false;
            }
        }
        return true;
    }
}