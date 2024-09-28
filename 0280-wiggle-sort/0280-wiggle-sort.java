import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int mid = (nums.length + 1) / 2; 
        int[] left = Arrays.copyOfRange(nums, 0, mid); 
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        int leftIndex = left.length - 1;
        int rightIndex = right.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = left[leftIndex--]; 
            } else {
                nums[i] = right[rightIndex--]; 
            }
        }
    }
}
