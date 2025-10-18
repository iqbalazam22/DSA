class MedianFinder {

    PriorityQueue<Integer> min;  // max heap means ki large uper rahega
    PriorityQueue<Integer> max;  // min heap means ki small uper rahega

    public MedianFinder() {
        min = new PriorityQueue<>(Collections.reverseOrder());
        max = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        min.add(num);

        if(!min.isEmpty() && !max.isEmpty() && min.peek() > max.peek())  max.add(min.remove());

        if(min.size() > max.size()+1) max.add(min.remove());
        else if(max.size() > min.size()) min.add(max.remove());
    }
    
    public double findMedian() {
        if(min.size() == max.size()) return (min.peek() + max.peek()) / 2.0;
        else return min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */