class Solution {
    int dp[];
    public int recur(int target, int coins[]){
        if(target == 0) return 0;
        // if (idx >= coins.length || target < 0) return 100000;
        if(dp[target] != -1) return dp[target];
        int ans = 100000;
        for(int i = 0; i < coins.length; i++){
            if(target >= coins[i]){
                int take = 1 + recur(target-coins[i], coins);
                ans = Math.min(ans, take);
            }
        }
        dp[target] = ans;
        return ans;
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        for(int j = 0; j < amount+1; j++)
        dp[j] = -1;
        int ans = recur(amount, coins);
        if(ans == 100000) return -1;
        return ans;
    }
}