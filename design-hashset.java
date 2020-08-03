// https://leetcode.com/problems/design-hashset/
class MyHashSet {

    // tc -> n/k(buckets), sc-> k(buckets)+m(unqiue values)
    List<Integer>[] buckets;
    int numBuckets;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        numBuckets = 15000;
        buckets = new LinkedList[numBuckets];
    }
    
    public int getHashCode(int key){
        return key%numBuckets;
    }
    
    public void add(int key) {
        int hashCode = getHashCode(key);
        if(buckets[hashCode]==null) buckets[hashCode] = new LinkedList<>();
        if(buckets[hashCode].indexOf(key)==-1)
            buckets[hashCode].add(key);
    }
    
    public void remove(int key) {
        int hashCode = getHashCode(key);
        if(buckets[hashCode]==null) return;
        if(buckets[hashCode].indexOf(key)!=-1)
            buckets[hashCode].remove(buckets[hashCode].indexOf(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashCode = getHashCode(key);
        if(buckets[hashCode]==null || buckets[hashCode].indexOf(key)==-1)
            return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
