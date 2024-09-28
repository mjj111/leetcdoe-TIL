import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        while (!numMap.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();

            for (int num : new ArrayList<>(numMap.keySet())) {
                tmp.add(num);

                numMap.put(num, numMap.get(num) - 1);

                if (numMap.get(num) == 0) {
                    numMap.remove(num);
                }
            }
            answer.add(tmp); 
        }

        return answer;
    }
}