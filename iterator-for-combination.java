// https://leetcode.com/problems/iterator-for-combination/
class CombinationIterator {

    // I guess - tc -> n*2^n, 1, sc-> k(given length)
    Queue<String> q;
    public CombinationIterator(String characters, int combinationLength) {
        q = new LinkedList<>();
        computeCombinations(characters, combinationLength, 0, new StringBuilder());
    }
    
    private void computeCombinations(String str, int len, 
                                     int index, StringBuilder sb){
        if(len==0){
            q.offer(sb.toString());
            return;
        }
        
        for(int i=index; i<str.length(); i++){
            sb.append(str.charAt(i));
            computeCombinations(str, len-1, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public String next() {
        return !q.isEmpty() ? q.poll() : "";
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
