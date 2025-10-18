import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap;  // Max-heap for smaller half
    private PriorityQueue<Integer> rightMinHeap; // Min-heap for larger half

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Add to left (max-heap) first
        leftMaxHeap.add(num);

        // Step 2: Move top of left to right if violated order property
        if (!leftMaxHeap.isEmpty() && !rightMinHeap.isEmpty()
                && leftMaxHeap.peek() > rightMinHeap.peek()) {
            rightMinHeap.add(leftMaxHeap.poll());
        }

        // Step 3: Balance sizes (difference ≤ 1)
        if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
        return leftMaxHeap.peek();
    }
}
