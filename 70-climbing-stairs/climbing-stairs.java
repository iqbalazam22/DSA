class Solution {
    int arr[];
    public int recur(int idx){
        if(idx == 0) return 1;
        if(idx <= 2) return idx;
        if(arr[idx] != -1) return arr[idx];
        int ans = recur(idx-1) + recur(idx-2);
        arr[idx] = ans;
        return ans;
    }
    public int climbStairs(int n) {
        arr = new int[n+1];
        for(int i = 0; i <= n; i++){
            arr[i] = -1;
        }
        return recur(n);
    }
}