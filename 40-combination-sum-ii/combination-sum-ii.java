class Solution {
    int dp[];
    List<List<Integer>> list;
    ArrayList<Integer> currList = new ArrayList<>();
    public void recur(int []candidates, int idx, int target){
        if(target == 0){
            list.add(new ArrayList<>(currList));
            return;
        }
        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) 
                break;
            if(target - candidates[i] >= 0){
                currList.add(candidates[i]);
                recur(candidates, i+1, target - candidates[i]);
                currList.remove(currList.size()-1);
                
            }
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // Arrays.fill(dp, -1);
        list = new ArrayList<>();
        recur(candidates, 0, target);
        return list;
    }
}