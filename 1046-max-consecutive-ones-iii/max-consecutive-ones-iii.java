class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero = 0, answer = 0;
        Deque<Integer> q = new LinkedList<>();
        int i = 0, n = nums.length;
        while(i<n){
            q.addLast(nums[i]);
            if(nums[i] == 0) zero++;

            while(zero > k && q.size() > 0){
                if(q.peekFirst() == 0){
                    zero--;
                }
                q.removeFirst();
            }
            answer = Math.max(answer, q.size());
            i++;
        }
        return answer;
    }
}