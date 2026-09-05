/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    static class Pair {
           Node node;
           int hd;

           Pair(Node node, int hd) {
               this.node = node;
               this.hd = hd;
           }
       }

       public ArrayList<Integer> topView(Node root) {
           ArrayList<Integer> ans = new ArrayList<>();
           if (root == null) return ans;
           
           TreeMap<Integer, Integer> map = new TreeMap<>();
           Queue<Pair> queue = new LinkedList<>();

           queue.add(new Pair(root, 0));

           while (!queue.isEmpty()) {
               Pair curr = queue.poll();
               Node node = curr.node;
               int hd = curr.hd;

               if (!map.containsKey(hd)) {
                   map.put(hd, node.data);
               }

               if (node.left != null) {
                   queue.add(new Pair(node.left, hd - 1));
               }

               if (node.right != null) {
                   queue.add(new Pair(node.right, hd + 1));
               }
           }

           for (int value : map.values()) {
               ans.add(value);
           }

           return ans;
    }
}