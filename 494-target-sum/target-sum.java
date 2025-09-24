class Solution {
    int dp[][];
    public int recur(int idx, int sum, int target, int nums[]){
        
        if(idx == nums.length){
            if(target == sum) return 1;
            else return 0;
        }
        
         if(dp[idx][sum] != -1) return dp[idx][sum];

        int op1 = 0, op2 = 0;

        if (target - nums[idx] >= 0) {
            op1 = recur(idx + 1, sum + nums[idx], target, nums);
        }
        if (target + nums[idx] <= 2000) {
            op2 = recur(idx + 1, sum - nums[idx], target, nums);
        }
        
        int ans = op1+op2;
        dp[idx][sum] = ans;
        return ans;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n][2000+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= 2000; j++) dp[i][j] = -1;
        }
        return recur(0, 1000, target+1000, nums);
    }
}