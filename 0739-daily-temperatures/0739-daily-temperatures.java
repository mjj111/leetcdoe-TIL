import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] result = new int[N];
        Stack<Node> tempStack = new Stack<>();
        
        for (int i = 0; i < N; i++){
            int nowTemperture = temperatures[i];
            
            while(!tempStack.empty() &&  tempStack.peek().value < nowTemperture){
                int idx = tempStack.pop().index;
                result[idx] = i - idx;
            }
            
            tempStack.push(new Node(i, nowTemperture));
        }

        return result;
    }
    
    class Node {
        int index;
        int value;
        
        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
