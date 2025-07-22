class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> list = new ArrayList<>();
       int i =0;
        while(i<nums.length){
            int currentElement = nums[i];
            int target = -currentElement;
            int a=i+1, b=nums.length-1;
                while(a<b){
                    int sum = nums[a]+nums[b];
                    if(sum == target){
                    list.add(Arrays.asList(nums[i],nums[a],nums[b]));
                    int currentE = nums[a];
                    while(a < nums.length && currentE == nums[a])a++;
                    currentE = nums[b];
                    while(b > 0 && currentE == nums[b])b--;
                    }
                    else if(sum > target)b--;
                    else a++;
                
                }    
                   
            while(i < nums.length && currentElement==nums[i]) i++;
        }
        return list;
    }
}