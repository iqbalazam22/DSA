class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < k; i++){
            sum+=nums[i];
        }
        int avg = sum / k;
        if(avg >= threshold) ans++;
        for(int i = k; i < nums.length; i++){
            sum -= nums[i-k];
            sum += nums[i];

            avg = sum / k;
            if(avg >= threshold) ans++;
        }
        return ans;
    }
}