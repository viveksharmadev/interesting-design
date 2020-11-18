// https://leetcode.com/problems/time-based-key-value-store/
class TimeMap {

    // tc -> n, sc-> n
    Map<String, Map<Integer, String>> cache;
    /** Initialize your data structure here. */
    public TimeMap() {
        cache = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        cache.putIfAbsent(key, new HashMap<>());
        cache.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!cache.containsKey(key)) return "";
        Map<Integer, String> map = cache.get(key);
        for(int i=timestamp; i>=0; i--){
            if(map.containsKey(i)) return map.get(i);
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
