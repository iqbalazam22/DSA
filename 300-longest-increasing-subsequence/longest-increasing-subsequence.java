class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        dp[0] = 1;
        int finalAns = 0;
        int currentAns = 1;
        for(int i = 0; i < n; i++){
            currentAns = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    currentAns = Math.max(currentAns, 1 + dp[j]);
                }
            }
            dp[i] = currentAns;
            finalAns = Math.max(finalAns, currentAns);
        }
        return finalAns;
    }
}