class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : richer) {
            int u = edge[0]; 
            int v = edge[1];
            adj.get(v).add(u); 
        }
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < n; i++) {
            dfs(i, adj, quiet, answer);
        }
        
        return answer;
    }
    
    private int dfs(int node, List<List<Integer>> adj, int[] quiet, int[] answer) {
        if (answer[node] != -1) {
            return answer[node];
        }
        
        answer[node] = node;
        
        for (int richerPerson : adj.get(node)) {
            int quietestInChain = dfs(richerPerson, adj, quiet, answer);
            
            if (quiet[quietestInChain] < quiet[answer[node]]) {
                answer[node] = quietestInChain;
            }
        }
        
        return answer[node];
    }
}