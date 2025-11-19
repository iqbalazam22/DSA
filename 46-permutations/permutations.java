class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> currList = new ArrayList<>();
    Boolean vis[];
    public void recur(int nums[]){
        if(currList.size() == nums.length){
            list.add(new ArrayList<>(currList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(vis[i] == true) continue;
            else{
                vis[i] = true;
                currList.add(nums[i]);
                recur(nums);
                currList.remove(currList.size()-1);
                vis[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        vis = new Boolean[nums.length];
        Arrays.fill(vis, false);
        recur(nums);
        return list;
    }
}