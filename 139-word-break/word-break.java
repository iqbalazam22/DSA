class Solution {
    Set<String> set = new HashSet<>();
    Boolean dp[];
    public boolean recur(int idx, String s){
        if(idx == s.length()) return true;
        if(dp[idx] != null) return dp[idx];

        boolean answer = false;
        for(int i = idx; i < s.length(); i++){
            String str = s.substring(idx, i+1);
            if(set.contains(str) && recur(i+1, s)){
                answer = true;
            }
        }
        dp[idx] = answer;
        return answer;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        set.addAll(wordDict);
        return recur(0, s);
    }
}