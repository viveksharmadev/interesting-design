// https://leetcode.com/problems/lfu-cache/
class LFUCache {
// tc -> 1, sc-> n
    class Node{
        int key, value;
        int cnt;
        Node prev, next;
        public Node(int k, int v){
            key = k;
            value = v;
            cnt = 1;
        }
    }
    
    class DLList{
        Node head, tail;
        int len;
        public DLList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }
        
        public void addHead(Node node){
            node.prev = head;            
            node.next = head.next; 
            head.next.prev = node;
            head.next = node;
            map.put(node.key, node);
            len++;
        }
        
        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            map.remove(node.key);
            len--;
        }
        
        public void removeTail(){
            remove(tail.prev);
        }
    }
    
    Map<Integer, DLList> freq;
    Map<Integer, Node> map;
    int capacity, size;
    int maxFreq;
    
    public LFUCache(int capacity) {
        freq = new HashMap<>();
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.maxFreq = 0;
    }
    
    public int get(int key) {
        if(map.get(key)==null) return -1;
        Node node = map.get(key);
        int prevFreq = node.cnt;
        DLList prevList = freq.get(prevFreq);
        prevList.remove(node);
        
        int currFreq = prevFreq+1;
        maxFreq = Math.max(maxFreq, currFreq);
        DLList currList = freq.getOrDefault(currFreq, new DLList());
        node.cnt++;
        currList.addHead(node);
        
        freq.put(prevFreq, prevList);
        freq.put(currFreq, currList);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(map.get(key)!=null){
            map.get(key).value = value;
            get(key);
            return;
        }
        
        Node node = new Node(key, value);
        DLList currList = freq.getOrDefault(1, new DLList());
        currList.addHead(node);
        size++;
        if(size > capacity){
            if(currList.len > 1){
                currList.removeTail();
            }else{
                for(int i=2; i<=maxFreq; i++){
                    if(freq.get(i)!=null && freq.get(i).len > 0){
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }
            size--;
        }
        freq.put(1, currList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
