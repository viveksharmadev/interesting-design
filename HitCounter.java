// https://leetcode.com/problems/design-hit-counter/
class HitCounter {

    int[] time;
    int[] hits;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        time = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int idx = timestamp%300;
        if(time[idx]!=timestamp){
            time[idx]=timestamp;
            hits[idx] = 1;
        }else{
            hits[idx]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for(int i=0; i<300; i++){
            if(timestamp-time[i]<300)
            total+=hits[i];
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
