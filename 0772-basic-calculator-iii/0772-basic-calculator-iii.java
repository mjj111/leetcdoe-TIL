class Solution {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>(); 
        Stack<Character> ops = new Stack<>();

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(num);
                num = 0; 
            } 
            
            else if (c == '(') {
                ops.push(c);
            } 
            
            else if (c == ')') {
                while (ops.peek() != '(') {
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                } 
                ops.pop(); 
            } 

            else {
                // 만약 현재 연산이 이전 연산보다 우선순위가 낮다면 
                // 이전에 연산들을 수행해준다. 
                while (!ops.isEmpty() && precedence(c, ops.peek())) {
                    nums.push(operation(ops.pop(), nums.pop(),nums.pop()));
                }
                // 연산이 끝나면 현재 연산 추가
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }

        return nums.pop();
    }

    private static int operation(char op, int b, int a) {
        if(op =='+') return  a + b;
        if(op =='-') return  a - b;
        if(op =='*') return  a * b;
        if(op =='/') return  a / b;
        return 0;
    }
    private static boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }
}