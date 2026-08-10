class Solution {
    public int reverse(int x) {
        long reversed = 0;
        while(x!=0){
            int dig = x%10;
            x = x/10;
            reversed = (reversed*10) + dig;
            if(reversed>Integer.MAX_VALUE || reversed<Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)reversed;
    }
}