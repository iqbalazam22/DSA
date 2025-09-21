class Solution {
    int dp[][];
    public int recur(int i, int j, int m, int n){
        if(i == m-1 && j == n-1) return 1;
        if((i == m && j != n) || (i != m && j == n)) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int op1 = 0;
        int op2 = 0;
        op1 = recur(i, j+1, m, n);
        op2 = recur(i+1, j, m, n);
        int ans = op1 + op2;
        dp[i][j] = ans;
        return ans;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                dp[i][j] = -1;
            }
        }
        return recur(0, 0, m, n);
    }
}