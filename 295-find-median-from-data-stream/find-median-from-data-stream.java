class MedianFinder {
    private PriorityQueue<Integer> small; // Max-heap
    private PriorityQueue<Integer> large; // Min-heap

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);

        // Step 2: Maintain order — all small <= all large
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }

        // Step 3: Balance size
        if(small.size() > large.size() + 1){
            large.add(small.remove());
        }else if(large.size() > small.size()){
            small.add(large.remove());
        }
    }
    
    public double findMedian() {
        if(small.size() == large.size()){
            double ans = (small.peek() + large.peek() ) / 2.0;
            return ans;
        }else{
            double ans = small.peek();
            return ans;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */