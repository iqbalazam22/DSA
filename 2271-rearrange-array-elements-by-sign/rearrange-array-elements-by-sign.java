class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[] pArr = new int[len/2];
        int[] nArr = new int[len/2];
        int nIdx = 0;
        int pIdx = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] < 0) nArr[nIdx++] = nums[i];
            else pArr[pIdx++] = nums[i];
        }
        int a = 0, b = 0;
        int[] arr = new int[len];
        for(int i = 0; i < nums.length; i+=2){
            arr[i] = pArr[a++];
            arr[i+1] = nArr[b++];
        }
        return arr;
    }
}