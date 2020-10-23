// https://leetcode.com/problems/read-n-characters-given-read4/

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
    
    // tc -> n, sc-> 1(temp buffer to keep 4 chars)
    public int read(char[] buf, int n) {
        
        int total = 0;
        char[] tempBuffer = new char[4];
        boolean eof = false;
      
        while(!eof && total < n){
            
            int count = read4(tempBuffer);
            
            eof = count < 4;
            
            count = Math.min(count, n-total);
            
            for(int i=0; i<count; i++){
                buf[total++] = tempBuffer[i];
            }
        }
        
        return total;
    }
}
