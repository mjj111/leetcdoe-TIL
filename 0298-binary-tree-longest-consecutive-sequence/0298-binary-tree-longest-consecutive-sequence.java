class Solution {
    private static int answer;
    public int longestConsecutive(TreeNode root) {
        answer= 0;
        find(root, 1);
        return answer;
    }
    private static void find(TreeNode root, int depth) {
        answer = Math.max(depth, answer);

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left != null){
            if(root.val + 1 == left.val) {
                find(left, depth + 1);
            }
            else {
                find(left, 1);
            }
        } 
        
        if(right != null){
            if(root.val + 1 == right.val) {
                find(right, depth + 1);
            }
            else {
                find(right, 1);
            }
        } 
    }
}