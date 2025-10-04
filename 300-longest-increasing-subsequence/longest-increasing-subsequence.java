class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 1;  // always +1 in length of answer while counting answers using dp

        int currAns = 1;   // for answer currently
        int finAns = 0;    // for maximum answer

        for(int i = 0; i < nums.length; i++){
            currAns = 1;        // reset to 1 each time loop runs
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    currAns = Math.max(currAns, 1 + dp[j]);
                }
            }
            dp[i] = currAns;
            finAns = Math.max(currAns, finAns);
        }
        return finAns;
    }
}