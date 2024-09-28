class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeros = 0;
        int start = 0;
        int maxLen = 0;

        int end =0;
        for(end =0; end < nums.length; end++) {
            if(nums[end] == 0) {
              zeros+= 1;
            }
            
            while(zeros > 1) {
                maxLen = Math.max(maxLen, end-start);
                if(nums[start] == 0) {
                    zeros--;
                }
                start += 1;
            }
        }
        maxLen = Math.max(maxLen, end-start);
        return maxLen;
        
    }
}