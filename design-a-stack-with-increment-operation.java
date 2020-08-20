// https://leetcode.com/problems/design-a-stack-with-increment-operation/
class CustomStack {

    // tc -> 1, sc-> n
    List<Integer> q;
    int maxSize;
    
    public CustomStack(int maxSize) {
        this.q = new LinkedList<>();
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(q.size()==maxSize) return;
        q.add(x);
    }
    
    public int pop() {
        return !q.isEmpty() ? q.remove(q.size()-1) : -1;
    }
    
    public void increment(int k, int val) {
        for(int i=0; i<k && i<q.size(); i++){
            q.set(i, val + q.get(i));
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
