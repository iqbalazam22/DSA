class Solution {
    Set<String> set = new HashSet<>();
    Boolean dp[];

    public boolean recur(int idx, String s){
        if(idx == s.length()) return true;
        if(dp[idx] != null) return dp[idx];

        boolean ans = false;
        
        for(int i = idx; i < s.length(); i++){
            String str = s.substring(idx, i+1);

            if(set.contains(str)){
                if(recur(i+1, s)){
                    ans = true;
                }
            }
        }
        dp[idx] = ans;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        dp = new Boolean[s.length()];
        return recur(0, s);
    }
}