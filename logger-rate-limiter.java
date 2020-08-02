// https://leetcode.com/problems/logger-rate-limiter/
class Logger {

    // tc -> 1, sc-> n
    Map<String, Integer> cache;
    /** Initialize your data structure here. */
    public Logger() {
        cache = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp < cache.getOrDefault(message,0)){
            return false;
        }
        cache.put(message, timestamp+10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
