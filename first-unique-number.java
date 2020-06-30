// https://leetcode.com/problems/first-unique-number/
class FirstUnique {

    Map<Integer, Boolean> isUnique;
    Queue<Integer> q;
    
    // tc -> n
    public FirstUnique(int[] nums) {
        isUnique = new HashMap<>();
        q = new LinkedList<>();
        for(int num : nums) add(num);
    }
    
    // tc -> 1 (amortized)
    /*
    Removing an item from a queue has a cost of O(1). The total number of these removals we need to carry out is proportional to the number of calls to add(), 
    because each add() corresponds to at most one removal that will ultimately have to happen. Then when we find a unique number, it is an O(1) operation to return it.
    */
    public int showFirstUnique() {        
        while(!q.isEmpty() && !isUnique.get(q.peek())){
            q.poll();
        }
        return !q.isEmpty() ? q.peek() : -1;
    }
    
    // tc -> 1
    public void add(int value) {
        
        if(!isUnique.containsKey(value)){            
            q.offer(value);
            isUnique.put(value, true);
        }else{
            isUnique.put(value, false);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
