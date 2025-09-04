class Solution {
    public int singleNumber(int[] nums) {
        int bits[] = new int[32];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < 32; j++){
                bits[j] += (nums[i] >> j) & 1;
            }
        }
        for(int j = 0; j < 32; j++){
            bits[j] %= 3;
        }
        int ans = 0;
        for(int j = 0; j < 32; j++){
            ans = ans + (bits[j] * square(2, j));
        }
        return ans;
    }
    public int square(int num, int power){
        int ans = 1;
        for(int i = 1; i <= power; i++){
            ans = ans*num;
        }
        return ans;
    }
}