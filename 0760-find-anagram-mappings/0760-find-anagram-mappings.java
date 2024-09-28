class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer,Integer> indexs = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            indexs.put(nums2[i], i);
        }

        int[] answer = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            answer[i] = indexs.get(target);
        }
        
        return answer;
    }
}