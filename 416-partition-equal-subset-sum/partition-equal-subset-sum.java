class Solution {
    Boolean dp[][];
    public boolean recur(int idx, int target, int nums[]){

        if(target == 0) return true;

        if (idx >= nums.length || target < 0) return false;

        if(dp[idx][target] != null) return dp[idx][target];
        
        boolean take = recur(idx+1, target-nums[idx], nums);
        boolean skip = recur(idx+1, target, nums);

        return dp[idx][target] = take || skip;
    }
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i : nums) target+=i;
        if(target % 2 != 0) return false;
        target /= 2;

        dp = new Boolean[nums.length+1][target+1];
        return recur(0, target, nums);
    }
}