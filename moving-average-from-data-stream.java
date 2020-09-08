// https://leetcode.com/problems/moving-average-from-data-stream/

class MovingAverage {

    // tc -> 1, sc-> n
    Queue<Integer> q;
    int size;
    double sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.size = size;
        this.sum = 0.0;
    }
    
    public double next(int val) {
        q.offer(val);
        sum += val;               
        if(q.size() > size) sum -= q.poll();
        double result = sum/q.size();
        return result;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
