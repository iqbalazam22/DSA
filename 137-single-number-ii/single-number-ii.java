class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        if(n == 1) ans = nums[0];
        for(int i = 0; i < n; i++){
            int left = (i-1+n)%n;
            int right = (i+1+n)%n;
            if(nums[i]!=nums[left] && nums[i]!=nums[right]){
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
}