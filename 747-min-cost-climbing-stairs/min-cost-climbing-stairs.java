class Solution {
    int dp[];
    public int recur(int idx, int[] cost){
        if(idx >= cost.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int op1 = 1000000;
        int op2 = 1000000;

        op1 = cost[idx] + recur(idx+1, cost);
        op2 = cost[idx] + recur(idx+2, cost);

        int ans = Math.min(op1, op2);
        dp[idx] = ans;
        return ans;
    }
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        for(int i = 0; i < cost.length; i++) dp[i] = -1;
        return Math.min(recur(1, cost), recur(0, cost));
    }
}