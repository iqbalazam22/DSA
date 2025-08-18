class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch) || map.get(ch) == 0){
                map.put(ch, map.getOrDefault(ch, 0)+1);
                q.add(ch);
                max = Math.max(max, q.size());
            }
            else{
                while(q.size() > 0 && q.peek() != ch){
                    char removed = q.remove();
                    map.put(removed, 0);
                }
                if(q.size() > 0){
                    q.remove();
                }
                q.add(ch);
                map.put(ch, 1);
            }
        }
        return max;
    }
}