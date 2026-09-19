/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class NodeInfo {
        boolean isBST;
        int sum; 
        int min;
        int max;

        NodeInfo(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    private int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }
    private NodeInfo traverse(TreeNode root) {
        if (root == null) {
            return new NodeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        NodeInfo left = traverse(root.left);
        NodeInfo right = traverse(root.right);

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int currentSum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, currentSum);

            int currentMin = Math.min(root.val, left.min);
            int currentMax = Math.max(root.val, right.max);

            return new NodeInfo(true, currentSum, currentMin, currentMax);
        }

        return new NodeInfo(false, 0, 0, 0);
}
}