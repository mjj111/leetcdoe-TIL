class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();

        int start = lower;

        for (int curr : nums) {
            if (start == curr) {
                start++;
                continue;
            } 

            if(start < curr) {
                result.add(List.of(start, curr-1));
                start = curr + 1;
            }
        }

        if (start <= upper) result.add(List.of(start, upper));

        return result;
    }
}