class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        q.add(a);
        q.add(b);
        q.add(c);

        int count = 0;

        while(q.size() > 1){

            int el1 = q.remove()-1;
            int el2 = q.remove()-1;

            if(el1 != 0) q.add(el1);
            if(el2 != 0) q.add(el2);

            count++;
        }   
        return count;
    }
}