class Solution {
    int dp[][];
    public int recur(int idx1, int idx2, String s1, String s2){
        if(idx1 == s1.length() || idx2 == s2.length()) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            dp[idx1][idx2] = 1 + recur(idx1 + 1, idx2 + 1, s1, s2);
        }else{
            dp[idx1][idx2] = Math.max(recur(idx1 + 1, idx2, s1, s2),
                                        recur(idx1,idx2 + 1, s1, s2));
        }
        return dp[idx1][idx2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];

        // initialize dp with -1 (unvisited state)
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur(0, 0, text1, text2);
    }
}