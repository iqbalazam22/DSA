class Solution {
    String s1;
    String s2;
    int dp[][];
    public int recur(int i, int j){
        int op1 = (int)(1e9);

        if(i == s1.length()) {
            if(j == s2.length()) return 0;
            return s2.length()-j;
        }
        if(j == s2.length()){
            if(i == s1.length()) return 0;
            return s1.length()-i;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            // match
           op1 =  recur(i+1, j+1);
        }
        // replace
        int op2 = 1 + recur(i+1, j+1);
        // insert
        int op3 = 1 + recur(i, j+1);
        // delete
        int op4 = 1 + recur(i+1, j);

        int ans = Math.min(op1, Math.min(op2, Math.min(op3, op4)));

        dp[i][j] = ans;
        return ans;
    }
    public int minDistance(String word1, String word2) {
        s1 = word1;
        s2 = word2;
        dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return recur(0, 0);
    }
}