class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int sum = 0;
        int pro = 1;
        int left = 0, right = 0;
        int n = nums.length;
        while(right < n){
                pro *= nums[right];
            while(pro >= k && left <= right){    
                pro /= nums[left];
                left++;
            }
            sum += (right-left+1);
            right++;
        }
           
        return sum;
    }
}