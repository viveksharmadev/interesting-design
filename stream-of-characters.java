// https://leetcode.com/problems/stream-of-characters/
class StreamChecker {
    // tc -> n(max word length i.e. depth of trie)
    // sc-> m(I think all words length)
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    
    TrieNode root;
    StringBuilder sb;    
    public StreamChecker(String[] words) {
        sb = new StringBuilder();
        root = new TrieNode();
        buildTrie(words);
    }
    
    private void buildTrie(String[] words){        
        for(String word : words){
            TrieNode node = root;
            for(int i=word.length()-1; i>=0; i--){
                char c = word.charAt(i);
                if(node.children[c-'a']==null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isWord = true;     
        }        
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for(int i=sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            if(node.children[c-'a']==null) return false;
            if(node.children[c-'a'].isWord) return true;
            node = node.children[c-'a'];
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
