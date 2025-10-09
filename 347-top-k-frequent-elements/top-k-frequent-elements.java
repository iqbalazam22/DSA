class Solution {

    public int[] reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // Swap arr[left] and arr[right]
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
        return arr; // return the same reversed array
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->{
            int fA = map.get(a), fB = map.get(b);

            return fA - fB;
        });
        for(Integer num : map.keySet()){
            q.add(num);

            if(q.size() > k) q.poll();
        }
        int arr[] = new int[q.size()];

        int i = 0;
        while(!q.isEmpty()){
            arr[i++] = q.remove();
        }
        
        int[] reversed = reverseArray(arr);

        return reversed;
        
    }
}