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
    private Map<Integer, Integer> sumCounts;
    private int maxCount;
    public int[] findFrequentTreeSum(TreeNode root) {
         if (root == null) return new int[0];
        
        sumCounts = new HashMap<>();
        maxCount = 0;
        calculateSubtreeSums(root);
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumCounts.entrySet()) {
            if (entry.getValue() == maxCount) {
                resultList.add(entry.getKey());
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }

    private int calculateSubtreeSums(TreeNode node) {
        if (node == null) return 0;
        
        // Post-order traversal: Left subtree -> Right subtree -> Current node
        int leftSum = calculateSubtreeSums(node.left);
        int rightSum = calculateSubtreeSums(node.right);
        
        int totalSum = node.val + leftSum + rightSum;
        
        // Update the frequency map
        int currentCount = sumCounts.getOrDefault(totalSum, 0) + 1;
        sumCounts.put(totalSum, currentCount);
        
        // Keep track of the highest frequency globally to avoid a second loop
        maxCount = Math.max(maxCount, currentCount);
        
        return totalSum;
    }
}