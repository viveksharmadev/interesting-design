// https://leetcode.com/problems/sum-of-left-leaves/
class Solution {
    // tc -> n, sc-> n
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        sumOfLeftLeavesInTree(root, false);
        return sum;
    }
    
    private void sumOfLeftLeavesInTree(TreeNode root, boolean isLeft){
        if(root==null) return;
        if(isLeft && root.left==null && root.right==null)
            sum += root.val;
        sumOfLeftLeavesInTree(root.left, true);
        sumOfLeftLeavesInTree(root.right, false);
    }
}

class Solution {
    //tc - N, sc - N
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, new int[1], false);
    }
    
    private int helper(TreeNode root, int[] sum, boolean flag){
        if(root==null) return 0;
        if(root.left==null && root.right==null && flag) sum[0]+=root.val;
        helper(root.left, sum, true);
        helper(root.right, sum, false);
        return sum[0];
    }
}
