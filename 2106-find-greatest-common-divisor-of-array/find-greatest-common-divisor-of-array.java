class Solution {
    public static int findGCD(int[] nums) {
        Arrays.sort(nums);
        int len= nums.length;
        int a = nums[len-1], b = nums[0];
         while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}