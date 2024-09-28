class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] chars = s.toCharArray();
        if(chars.length <= k) {
            return chars.length;
        } 

        int start = 0;
        int end = 0;

        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put(chars[0], 1);

        int maxLength = -1; 
        while(end < s.length() -1) {

            while(charMap.size() <= k) {
                maxLength = Math.max(maxLength, end - start);
                
                end++;
                if(end > s.length()-1) break;

                char endChar = chars[end];
                int value = charMap.getOrDefault(endChar, 0);
                charMap.put(endChar, value + 1);
            }

            while(charMap.size() > k) {
                char startChar = chars[start];
                int value = charMap.get(startChar);
                charMap.put(startChar, value - 1);

                if(value -1 == 0) charMap.remove(startChar);
                
                start++;
            }
        }
        
        return maxLength + 1;
    }
}