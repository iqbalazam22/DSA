class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int arr2[] = new int[n];
        arr[0] = nums[0];
        arr2[n-1] = nums[n-1];
        for(int i = 1; i < n; i++){
            arr[i] = arr[i-1]+nums[i];
        }
        for(int i = n-2; i >= 0; i--){
            arr2[i] = arr2[i+1] + nums[i];
        }
        for(int i = 0; i < n; i++){
            if(arr[i] == arr2[i]) return i;
        }
        return -1;
    }
}