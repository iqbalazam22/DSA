class Solution {
    int dp[][];
    public int recur(int curr, int idx, int[] nums){
        if(idx == nums.length) return 0;
        if(dp[idx][curr+1] != -1) return dp[idx][curr+1];
        int ans1 = 0;
        int ans2 = 0;
        
        if(curr == -1 || nums[curr] < nums[idx]){
            ans1 = 1 + recur(idx, idx+1, nums);
        }
        ans2 = recur(curr, idx+1, nums);
        
        int ans = Math.max(ans1, ans2);
        dp[idx][curr+1] = ans;
        return ans;

    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= n; j++) dp[i][j] = -1;
        }
        return recur(-1, 0, nums);
    }
}