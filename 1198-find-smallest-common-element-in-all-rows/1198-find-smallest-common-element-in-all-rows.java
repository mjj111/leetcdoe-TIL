class Solution {
    public int smallestCommonElement(int[][] mats) {
        Map<Integer,Integer> numMap = new HashMap<>();

        for(int[] mat : mats) {
            for(int num : mat) {
                numMap.put(num, numMap.getOrDefault(num, 0) + 1);
            }
        }
        
        // 열 
        for(int i = 0; i < mats[0].length; i++) {
            int minValue = Integer.MAX_VALUE;
            for(int j = 0; j < mats.length; j++) {
                int now = mats[j][i];
                if(numMap.get(now) == mats.length) {
                    minValue = Math.min(minValue, now);
                }
            }
            if(minValue != Integer.MAX_VALUE) return minValue;
        }

        return -1;
    }
}