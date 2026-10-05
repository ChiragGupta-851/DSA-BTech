class Solution {
    public boolean isPowerOfThree(int n) {
        return n>0 && 1162261467%n == 0; //1162261647 is the largest power of 3 number( 3^19) 
    }
}