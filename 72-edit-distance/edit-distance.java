class Solution {
    String s1;
    String s2;
    int dp[][];

    public int recur(int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = recur(i - 1, j - 1); // no cost if same
        }

        int op2 = 1 + recur(i - 1, j - 1); // replace
        int op3 = 1 + recur(i - 1, j);     // delete
        int op4 = 1 + recur(i, j - 1);     // insert

        int ans = Math.min(op2, Math.min(op3, op4));
        dp[i][j] = ans;
        return ans;
    }

    public int minDistance(String word1, String word2) {
        s1 = word1;
        s2 = word2;
        dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return recur(s1.length(), s2.length());
    }
}
