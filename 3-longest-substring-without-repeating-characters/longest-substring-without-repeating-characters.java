class Solution {
    public int lengthOfLongestSubstring(String s) {
        int x = 0;
        int c = 0;
        

        for(int i =0;i<s.length();i++){
            boolean[] b = new boolean[128];
            int lim = Math.min(s.length(),i+100);
            for(int j = i;j<lim;j++){
                char d = s.charAt(j);
                if(b[d]){
                    break;
                }
                
                b[d] = true;
                c = Math.max(c,j-i+1);
                
            }
        }
        return c;
        
    }
}