class Solution {
  public int longestConsecutive(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for(int i = 0; i< nums.length; i++){
        set.add(nums[i]);
      }
      int curr = 1, max = 1;
      if(nums.length == 0 || nums.length == 1) return nums.length;

      for(Integer num : set){
        if(!set.contains(num-1)){
          int currnetNum = num;
          while(set.contains(currnetNum+1)){
            currnetNum++;
            curr++;
          }
          max = Math.max(max, curr);
          curr = 1;
        }
      }
      return max;
  }
}