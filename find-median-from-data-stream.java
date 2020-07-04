// https://leetcode.com/problems/find-median-from-data-stream/
class MedianFinder {

    // tc -> logn, sc-> n
    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> higher;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        lower = new PriorityQueue<>((a,b) -> b-a);
        higher = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lower.offer(num);
        higher.offer(lower.peek());
        lower.poll();
        if(lower.size() < higher.size()) {
            lower.offer(higher.peek());
            higher.poll();
        }
    }
    
    public double findMedian() {
        return lower.size()==higher.size()
            ? (lower.peek() + higher.peek())/2.0 
            : lower.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
