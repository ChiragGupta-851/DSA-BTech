class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            isPre[u][v] = true; 
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPre[i][k] && isPre[k][j]) {
                        isPre[i][j] = true;
                    }
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            ans.add(isPre[u][v]);
        }
        
        return ans;

    }
}