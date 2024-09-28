class Solution {
    public int countElements(int[] arr) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for(int num : arr) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        int answer = 0;
        for(int num : arr) {
            if (numMap.containsKey(num+1)) answer += 1;
        }
        return answer;
    }
}