class Solution {
    public int longestConsecutive(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if(nums.length == 0) return 0;

        for(int i = 0; i < nums.length; i++){
          map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int ans = 1, max = 1;
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        
        for(int i =0; i < keys.size()-1; i++){
          if(keys.get(i)+1 == keys.get(i+1)){
            ans++;
          }else{
            ans = 1;
          }
          max = Math.max(max, ans);
        }
        return max;
    }
}