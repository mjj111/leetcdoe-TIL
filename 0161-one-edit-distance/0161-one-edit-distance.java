class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int minLength = Math.min(s.length(), t.length());

        int sIndex = 0;
        int tIndex = 0;

        for (int i = 0; i < minLength; i++) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
                continue;
            }

            // 문자가 다를 경우 3가지 가능한 편집 시나리오를 검사
            return isOneDistance(s, t, sIndex + 1, tIndex + 1) // 문자 하나를 교체하는 경우
                    || isOneDistance(s, t, sIndex, tIndex + 1) // t 문자열에 문자 하나가 삽입된 경우
                    || isOneDistance(s, t, sIndex + 1, tIndex); // s 문자열에 문자 하나가 삽입된 경우
        }

        return Math.abs(s.length() - t.length()) == 1;
    }
    
    private boolean isOneDistance(String s, String t, int sIndex, int tIndex) {
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) != t.charAt(tIndex)) {
                return false;
            }
            sIndex++;
            tIndex++;
        }

        return sIndex == s.length() && tIndex == t.length();  
    }    
}