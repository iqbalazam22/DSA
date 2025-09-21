class Solution {
    int dp[];
    public int recur(int i, int cost[]){
        if(i >= cost.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int op1 = (int)(1e9);
        int op2 = (int)(1e9);

        op1 = cost[i] + recur(i+1, cost);
        op2 = cost[i] + recur(i+2, cost);

        int ans = Math.min(op1, op2);
        dp[i] = ans;
        return ans;
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        for(int i = 0; i <= n; i++) dp[i] = -1;
        return Math.min(recur(0, cost), recur(1, cost));
    }
}