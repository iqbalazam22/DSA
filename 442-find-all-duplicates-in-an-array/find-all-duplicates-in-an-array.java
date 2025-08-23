class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i] , 0)+1);
        }
        map.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .forEach(e -> list.add(e.getKey()));
        return list;
    }
}