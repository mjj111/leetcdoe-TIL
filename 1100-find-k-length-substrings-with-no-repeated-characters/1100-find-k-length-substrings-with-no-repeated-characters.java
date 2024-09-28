class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.length() < k) return 0;
        Map<Character, Integer> mapC = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            mapC.put(c, mapC.getOrDefault(c, 0) + 1);
        }
        if (isAllNotBig(mapC)) answer += 1;

        for (int i = 1; i <= s.length() - k; i++) {
            char before = s.charAt(i - 1);
            char next = s.charAt(i + k - 1);

            mapC.put(before, mapC.get(before) - 1);
            if (mapC.get(before) == 0) {
                mapC.remove(before);
            }

            mapC.put(next, mapC.getOrDefault(next, 0) + 1);
            if (isAllNotBig(mapC)) answer += 1;
        }

        return answer;
    }

    private static boolean isAllNotBig(Map<Character, Integer> mapC) {
        for (int value : mapC.values()) {
            if (value > 1) return false;
        }
        return true;
    }
}
