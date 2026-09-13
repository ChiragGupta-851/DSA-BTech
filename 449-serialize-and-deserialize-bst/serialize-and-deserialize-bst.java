/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    //encoding
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString().trim();
    }

    private void serializeDFS(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(" ");
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }

    // Decoding
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        for (String s : data.split(" ")) {
            queue.offer(Integer.parseInt(s));
        }
        
        return deserializeDFS(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeDFS(java.util.Queue<Integer> queue, int min, int max) {
        if (queue.isEmpty()) {
            return null;
        }
        
        int val = queue.peek();
        if (val < min || val > max) {
            return null;
        }
        queue.poll();
        TreeNode root = new TreeNode(val);
        
        root.left = deserializeDFS(queue, min, val);
        root.right = deserializeDFS(queue, val, max);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;