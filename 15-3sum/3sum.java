class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int firstInt = nums[i];
            int target = -firstInt;
            
            int start = i+1; 
            int end = n-1;
            
            while(start < end){
                if(nums[start] + nums[end] == target){
                    ArrayList<Integer> ans = new ArrayList<>();
                    list.add(Arrays.asList(firstInt, nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                }
                if(start < end && nums[start] + nums[end] > target) end--;
                else if(start < end && nums[start] + nums[end] < target) start++;
               
            }
        }
        return list;
    }
}