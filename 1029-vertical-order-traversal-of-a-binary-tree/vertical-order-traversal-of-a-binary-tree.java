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
    static class Tuple {
        TreeNode node;
        int hd;   // Horizontal distance (column)
        int row;  // Vertical level (row)

        Tuple(TreeNode node, int hd, int row) {
            this.node = node;
            this.hd = hd;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<List<Integer>>> tempResult = new ArrayList<>(); 
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple curr = queue.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;
            int row = curr.row;
            map.putIfAbsent(hd, new TreeMap<>());

            map.get(hd).putIfAbsent(row, new PriorityQueue<>());
            map.get(hd).get(row).add(node.val);

            if (node.left != null) {
                queue.add(new Tuple(node.left, hd - 1, row + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, hd + 1, row + 1));
            }
        }

        for (Map<Integer, PriorityQueue<Integer>> colMap : map.values()) {
            List<Integer> currentColumn = new ArrayList<>();
            for (PriorityQueue<Integer> pq : colMap.values()) {
                while (!pq.isEmpty()) {
                    currentColumn.add(pq.poll());
                }
            }
            result.add(currentColumn);
        }

        return result;
    }
}