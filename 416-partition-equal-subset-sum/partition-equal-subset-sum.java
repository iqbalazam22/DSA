class Solution {
    Boolean dp[][];

    public boolean recur(int i, int target, int nums[]) {
        if (target == 0) return true;               // found subset
        if (i >= nums.length || target < 0) return false; // invalid case

        if (dp[i][target] != null) return dp[i][target];

        // try taking nums[i] or skipping it
        boolean take = recur(i + 1, target - nums[i], nums);
        boolean skip = recur(i + 1, target, nums);

        return dp[i][target] = take || skip;
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;

        if (total % 2 != 0) return false; // odd sum can't be partitioned

        int target = total / 2;
        dp = new Boolean[nums.length][target + 1];

        return recur(0, target, nums);
    }
}
