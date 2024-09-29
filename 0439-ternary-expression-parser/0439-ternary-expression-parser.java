class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        int N = expression.length();
        for (int i = N - 1; i >= 0; i--) {
            char curr = expression.charAt(i);
            
            if (curr >= '0' && curr <= '9' || curr == 'T' || curr == 'F') {
                stack.push(curr);
                continue;
            } 

            if (curr == '?') {
                char onTrue = stack.pop();
                char onFalse = stack.pop();
                stack.push(expression.charAt(--i) == 'T' ? onTrue : onFalse);
            }
        }
        return String.valueOf(stack.pop());
    }
}