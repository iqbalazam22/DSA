class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];

        int left = 0;
        for(int i = 0; i < n; i++){
            left += nums[i];
            if(sum - left == left - nums[i]){
                return i;
            }
        }
        return -1;
    }
}