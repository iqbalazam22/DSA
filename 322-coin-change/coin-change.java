class Solution {
    int dp[][];
    public int recur(int idx, int target, int coins[]){
        if(target == 0) return 0;
        if (idx >= coins.length || target < 0) return 100000;
        if(dp[idx][target] != -1) return dp[idx][target];
        int take = 1 + recur(idx, target-coins[idx], coins);
        int skip = recur(idx+1, target, coins);
        int ans = Math.min(take, skip);
        dp[idx][target] = ans;
        return ans;
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < amount+1; j++)
            dp[i][j] = -1;
        }
        int ans = recur(0, amount, coins);
        if(ans == 100000) return -1;
        return ans;
    }
}