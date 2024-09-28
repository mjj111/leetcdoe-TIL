class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int num : nums) {
            numMap.put(num,numMap.getOrDefault(num, 0) + 1);
        }

        int answer = -1;
        for(int key : numMap.keySet()) {
            if(numMap.get(key) == 1) {
                answer = Math.max(key, answer);
            }
        }
        return answer;
    }
}