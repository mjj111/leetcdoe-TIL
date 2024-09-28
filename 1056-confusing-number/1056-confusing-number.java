class Solution {
    public boolean confusingNumber(int n) {
        Map<Character,Character> digits = new HashMap<>();
        digits.put('0','0');
        digits.put('1','1');
        digits.put('6','9');
        digits.put('8','8');
        digits.put('9','6');

        String strN = String.valueOf(n);
        char[] charsN = strN.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(char c : charsN) {
            if (!digits.containsKey(c)) {
                return false;
            }

            sb.append(digits.get(c));
        }

        if (strN.equals(sb.reverse().toString())) {
            return false;
        }
        return true;
    }
}