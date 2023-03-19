class WordDictionary {
    private TrieNode root; 


    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
         TrieNode node = root;
        for (char c: word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.val = word;
    }
    
    public boolean search(String word) {
        return match(word, 0, root);
    }
    private boolean match(String word, int depth, TrieNode node){
        if(depth == word.length()) return !node.val.equals("");
        if(word.charAt(depth) != '.'){
            return (node.children[word.charAt(depth) - 'a'] != null && match(word, depth + 1, node.children[word.charAt(depth) - 'a'] ));
        }
        else{
            for (int i = 0; i < node.children.length; i++){
                if(node.children[i] != null && match(word, depth + 1, node.children[i]))
                    return true;
            }
        }
        return false;
}
}
class TrieNode{
        public TrieNode [] children = new TrieNode[26];
        public String val = "";
    }

