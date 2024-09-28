class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        if(chars.length <= 2) {
            return chars.length;
        } 

        int start = 0;
        int end = 0;

        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put(chars[0], 1);

        int maxLength = -1; 
        while(end < s.length() -1) {

            while(charMap.size() <= 2) {
                maxLength = Math.max(maxLength, end - start);
                
                end++;
                if(end > s.length()-1) break;

                char endChar = chars[end];
                int value = charMap.getOrDefault(endChar, 0);
                charMap.put(endChar, value + 1);
            }

            while(charMap.size() > 2) {
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