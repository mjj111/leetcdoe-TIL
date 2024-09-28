class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int start = i + 1;
            int end = nums.length - 1;

            while (start != end) {
                int total = nums[i] + nums[start] + nums[end];

                if (total > 0) {
                    end--;
                } 
                else if (total < 0) {
                    start++;
                } 
                else if (total == 0){
                    res.add(List.of(nums[i], nums[start], nums[end]));
                    start++;

                    while (nums[start] == nums[start-1] && start < end) {
                        start++;
                    }
                }
            }
        }
        return res;        
    }
}