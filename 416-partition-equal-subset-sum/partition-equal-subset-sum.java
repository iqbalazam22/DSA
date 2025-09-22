class Solution {
    Boolean dp[][];
    public boolean recur(int i, int target, int nums[]){
        if(i >= nums.length || target < 0) return false;
        if(target == 0) return true;
        if (dp[i][target] != null) return dp[i][target];
        boolean take = recur(i+1, target-nums[i], nums);
        boolean skip = recur(i+1, target, nums);
        boolean ans = take || skip;
        dp[i][target] = ans;
        return ans;

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int target = 0;
        for(int i = 0; i < n; i++) {
            target += nums[i];
        }
        if (target % 2 != 0) return false;
        target /= 2;
        dp = new Boolean[nums.length][target + 1];
        return recur(0, target, nums);
    }
}