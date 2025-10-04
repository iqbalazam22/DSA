class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;  // it will tell how many bits are different as 1^0 = 1 and 1^1 or 0^0 = 0

        int count = 0;
        while(xor != 0){
            xor = xor & (xor - 1);    
            count++;
        }
        return count;
    }
}
// this always removes right set bit, as 1101 & 1100 it will remove last 1, them it will be 1100 & 1011 again removes last then 1000 & 0000 => 0000, 
// and counter will be updated by 1 always until it is 0