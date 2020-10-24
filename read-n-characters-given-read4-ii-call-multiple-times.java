// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    
    private int prevCounter = 4;
        
    private char[] tempBuffer = new char[4];
    
    private int count = 0;
 
    // tc -> n, sc-> 1
    public int read(char[] buf, int n) {
        int total = 0;
        boolean eof = false;
        
        while(!eof && total < n){
            
            // This piece is processing from 
            // where it left off during last call
            while(prevCounter < count && total < n){
                buf[total++] = tempBuffer[prevCounter++];                         }
            
            // count need to be persisted among different calls
            // to execute above block successfully
            if(total < n){
                prevCounter = 0;
                
                count = read4(tempBuffer);

                int minCount = Math.min(count, n-total);

                eof = count < 4;

                for(;prevCounter<minCount;){
                    buf[total++] = tempBuffer[prevCounter++];
                }
            }
            
        }
        
        return total;
    }
}
