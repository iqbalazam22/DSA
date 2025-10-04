class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int ans = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){ 
            ans = nums[i];
            break;
            }
        }
        return ans;
    }
}