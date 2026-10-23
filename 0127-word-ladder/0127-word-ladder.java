class Pair{
    String first;
    int second;
    Pair(String _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord)==true) return steps;
            //this part will work for n*wordlength* 26 times
            for(int i = 0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replaced[] = word.toCharArray();
                    replaced[i] = ch;
                    String replacedword = new String(replaced);
                    if(st.contains(replacedword)==true){
                        st.remove(replacedword);
                        q.add(new Pair(replacedword,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}