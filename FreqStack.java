// https://leetcode.com/problems/maximum-frequency-stack/
class FreqStack {
    // tc -> 1, sc-> n
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> stackMap;
    int maxFreq;
    
    public FreqStack() {
        freqMap = new HashMap<>();
        stackMap = new HashMap<>();
        maxFreq = Integer.MIN_VALUE;
    }
    
    public void push(int x) {
        int freq = freqMap.getOrDefault(x,0)+1;
        freqMap.put(x, freq);
        stackMap.putIfAbsent(freq, new Stack<>());
        stackMap.get(freq).push(x);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        int val = stackMap.get(maxFreq).pop();
        freqMap.put(val, freqMap.get(val)-1);
        if(stackMap.get(maxFreq).size()==0) maxFreq--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
