class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int openIdx = stack.pop();
                pair[openIdx] = i;
                pair[i] = openIdx;
            }
        }

        StringBuilder result = new StringBuilder();
        int step = 1; 
        for (int i = 0; i < n; i += step) {
            char curr = s.charAt(i);
            
            if (curr == '(' || curr == ')') {
                i = pair[i];    
                step = -step;  
            } else {
                result.append(curr); 
            }
        }

        return result.toString();
    }
}