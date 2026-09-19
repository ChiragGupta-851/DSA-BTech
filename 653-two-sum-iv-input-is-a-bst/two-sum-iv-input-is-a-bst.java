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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        TreeNode currLeft = root;
        while (currLeft != null) {
            leftStack.push(currLeft);
            currLeft = currLeft.left;
        }
        TreeNode currRight = root;
        while (currRight != null) {
            rightStack.push(currRight);
            currRight = currRight.right;
        }
        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode leftNode = leftStack.peek();
            TreeNode rightNode = rightStack.peek();
            if (leftNode == rightNode) {
                break;
            }

            int currentSum = leftNode.val + rightNode.val;

            if (currentSum == k) {
                return true;
            } else if (currentSum < k) {
                TreeNode node = leftStack.pop();
                TreeNode curr = node.right;
                while (curr != null) {
                    leftStack.push(curr);
                    curr = curr.left;
                }
            } else {
                TreeNode node = rightStack.pop();
                TreeNode curr = node.left;
                while (curr != null) {
                    rightStack.push(curr);
                    curr = curr.right;
                }
            }
        }

        return false;
    }
}