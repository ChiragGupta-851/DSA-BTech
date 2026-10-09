class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        currentPath.add(0);
        dfs(0, graph, currentPath, result);
        
        return result;
    }
    
    private void dfs(int node, int[][] graph, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
      
        for (int neighbor : graph[node]) {
            currentPath.add(neighbor);             
            dfs(neighbor, graph, currentPath, result); 
            currentPath.remove(currentPath.size() - 1); 
        }
    }
    }
