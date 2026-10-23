class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
    
        if (!dict.contains(endWord)) return results;
        Map<String, List<String>> adjMap = new HashMap<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        boolean foundEnd = bfs(beginWord, endWord, dict, adjMap, distanceMap);
        
        if (foundEnd) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, adjMap, distanceMap, path, results);
        }
        
        return results;
    }
    
    private boolean bfs(String beginWord, String endWord, Set<String> dict, 
                        Map<String, List<String>> adjMap, Map<String, Integer> distanceMap) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);
        
        boolean foundEnd = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int currDistance = distanceMap.get(word);
                
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String nextWord = new String(chars);
                        
                        if (dict.contains(nextWord)) {
                            if (!distanceMap.containsKey(nextWord)) {
                                distanceMap.put(nextWord, currDistance + 1);
                                queue.offer(nextWord);
                                
                                adjMap.putIfAbsent(nextWord, new ArrayList<>());
                                adjMap.get(nextWord).add(word); 
                            } 
                            else if (distanceMap.get(nextWord) == currDistance + 1) {
                                adjMap.get(nextWord).add(word);
                            }
                            
                            if (nextWord.equals(endWord)) {
                                foundEnd = true;
                            }
                        }
                    }
                    chars[j] = originalChar; 
                }
            }
            if (foundEnd) break; 
        }
        return foundEnd;
    }
    
    private void dfs(String currWord, String beginWord, Map<String, List<String>> adjMap, 
                     Map<String, Integer> distanceMap, List<String> path, List<List<String>> results) {
        
        if (currWord.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            results.add(validPath);
            return;
        }
        if (!adjMap.containsKey(currWord)) return;
        
        for (String parent : adjMap.get(currWord)) {
            if (distanceMap.get(parent) == distanceMap.get(currWord) - 1) {
                path.add(parent);
                dfs(parent, beginWord, adjMap, distanceMap, path, results);
                path.remove(path.size() - 1); 
            }
        }
    }
}